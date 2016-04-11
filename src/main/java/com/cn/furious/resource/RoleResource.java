package com.cn.furious.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.furious.Tree.INode;
import com.cn.furious.Tree.Tree;
import com.cn.furious.json.result.AjaxObject;
import com.cn.furious.model.Menu;
import com.cn.furious.model.Permission;
import com.cn.furious.model.Role;
import com.cn.furious.service.MenuService;
import com.cn.furious.service.PermissionService;
import com.cn.furious.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleResource {

	private final static String ROLE_LIST = "/role/list";
	private final static String ROLE_CREATE = "/role/create";
	private final static String ROLE_UPDATE = "/role/update";
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping(value = "/list",method = {RequestMethod.GET,RequestMethod.POST})
	public String roleList(HttpServletRequest request){
		request.setAttribute("roles", roleService.getAll());
		return ROLE_LIST;
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String createUi(HttpServletRequest request){
		List<Menu> menus = menuService.getAll();
		Tree tree = new Tree(menus);
		Menu menu = new Menu();
		List<INode> nodes = tree.buildTree();
		menus = new ArrayList<>();
		for(INode node : nodes){
			menus.add((Menu)node);
		}
		menu.setChildren(menus);
		request.setAttribute("module", menu);
		return ROLE_CREATE;
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	@Transactional
	public @ResponseBody String create(HttpServletRequest request,Role role){
		List<String> permissionNames = new ArrayList<>();
		Long roleId = roleService.create(role);
		//拆字符串
		for(String name : role.getPermissionNames()){
			if(!StringUtils.isBlank(name)){
				if(name.contains(",")){
					String[] names = name.split(",");
					permissionNames.addAll(Arrays.asList(names));
				}else{
					permissionNames.add(name);
				}		
			}
		}
		role.setPermissionNames(permissionNames);
		List<Permission> permissions = new ArrayList<>();

		for(String name : permissionNames){
			Permission permission = new Permission();
			permission.setPermissionName(name);
			permission.setRoleId(roleId);
			permissions.add(permission);
		}
		permissionService.create(permissions);
		
		AjaxObject ajaxObject = new AjaxObject("角色添加成功！");
		return ajaxObject.toString();
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
	public String updateUi(HttpServletRequest request, @PathVariable Long id){
		List<Menu> menus = menuService.getAll();
		Tree tree = new Tree(menus);
		Menu menu = new Menu();
		List<INode> nodes = tree.buildTree();
		menus = new ArrayList<>();
		for(INode node : nodes){
			menus.add((Menu)node);
		}
		menu.setChildren(menus);
		request.setAttribute("module", menu);

		Role role = new Role();
		role.setId(id);
		role = roleService.queryRole(role);
		List<String> permissions = permissionService.query(role);
		//获取role的permissions
		role.setPermissionNames(permissions);
		request.setAttribute("role", role);
	
		return ROLE_UPDATE;
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public @ResponseBody String update(HttpServletRequest request,Role role){
		
		if(role == null
				||CollectionUtils.isEmpty(role.getPermissionNames())){
			return new AjaxObject().toString();
		}
		
		roleService.deletePermissions(role);
		List<String> permissionNames = new ArrayList<>();
		Long roleId = role.getId();
		
		for(String name : role.getPermissionNames()){
			if(!StringUtils.isBlank(name)){
				if(name.contains(",")){
					String[] names = name.split(",");
					permissionNames.addAll(Arrays.asList(names));
				}else{
					permissionNames.add(name);
				}		
			}
		}
		role.setPermissionNames(permissionNames);
		List<Permission> permissions = new ArrayList<>();

		for(String name : permissionNames){
			Permission permission = new Permission();
			permission.setPermissionName(name);
			permission.setRoleId(roleId);
			permissions.add(permission);
		}
		permissionService.create(permissions);
		
		AjaxObject ajaxObject = new AjaxObject("角色添加成功！");
		return ajaxObject.toString();

	}
	
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody String delete(HttpServletRequest request,@PathVariable Long id){
		Role role = new Role();
		role.setId(id);
		roleService.delete(role);
		AjaxObject ajaxObject = new AjaxObject();
		ajaxObject.setCallbackType("");
		return ajaxObject.toString();
	}
}
