package com.cn.furious.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.furious.Tree.INode;
import com.cn.furious.Tree.MenuTreeBuilder;
import com.cn.furious.json.result.AjaxObject;
import com.cn.furious.model.Menu;
import com.cn.furious.model.Permission;
import com.cn.furious.model.Role;
import com.cn.furious.model.User;
import com.cn.furious.service.MenuService;
import com.cn.furious.service.UserService;

@Controller
@RequestMapping("/menu")
public class MenuResource {
	
	private static final String INDEX = "/test";
	private static final String MENU_MAIN = "/menu/main";
	private static final String MENU_LIST = "/menu/list";
	private static final String MENU_CREATE = "/menu/create";
	private static final String MENU_UPDATE = "/menu/update";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MenuService menuService;

	
	@RequestMapping("/main")
	public String menuList(HttpServletRequest request){
		
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();	
		//TODO
		user = new User();
		user.setUsername("admin");
		//TODO 如果是超级管理员就查出所有的
		user = userService.query(user);	
		List<INode> menus = getMenu(user.getRoles());
		request.setAttribute("menuModule", menus);
		return MENU_MAIN;
	}
	
	@RequestMapping("/init")
	public String menu(HttpServletRequest request){
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();	
		//TODO
		user = new User();
		user.setUsername("admin");
		//TODO 如果是超级管理员就查出所有的
		user = userService.query(user);	
		List<INode> menus = getMenu(user.getRoles());
		request.setAttribute("menuModule", menus);
		return INDEX;
	}
	
	@RequestMapping(value = "/list/{id}",method = {RequestMethod.GET,RequestMethod.POST})
	public String list(HttpServletRequest request,@PathVariable Long id){
		
		if(id.longValue() == 0){
			Menu menu = new Menu();
			List<Menu> menus = menuService.getAll();
			request.setAttribute("menuModule", menus);
			request.setAttribute("parentId", id);
			return MENU_LIST;
		}
		
		Menu menu = new Menu();
		menu.setParentId(id);
		List<Menu> menus = menuService.queryChildren(menu);
		request.setAttribute("menuModule", menus);
		request.setAttribute("parentId", id);
		return MENU_LIST;
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.GET)
	public String create(HttpServletRequest request){

		return MENU_CREATE;
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public @ResponseBody String create(HttpServletRequest request,Menu menu){
	
		if(menu.getParentId().longValue() != 0){
			AjaxObject ajaxObject = new AjaxObject();
			return ajaxObject.toString();
		}
		
		if(menu.getParentId() == null){
			menu.setParentId(new Long(0));
		}
		menuService.create(menu);
		AjaxObject ajaxObject = new AjaxObject();
		ajaxObject.setCallbackType("closeCurrent");
		ajaxObject.setRel("jbsxBox2module");
		return ajaxObject.toString();
	}
	
	//先拿到用户的角色，再拿到角色的权限，再拿到所有的菜单，对比下取出角色拥有的菜单
	private List<INode> getMenu(List<Role> roles) {
		if(CollectionUtils.isEmpty(roles)){
			return null;
		}
		// 得到用户所有权限
		Set<Permission> permissionSet = new HashSet<>();
		for (Role role : roles) {
			Set<Permission> permissions = new HashSet<>(role.getPermissions());
			permissionSet.addAll(permissions);
		}
		//过滤得到用户拥有的菜单(view)
		List<Menu> menus = menuService.getAll();
		List<INode> authencatedMenus = null;
		try{
			MenuTreeBuilder builder = new MenuTreeBuilder();
			builder.init(permissionSet, menus);
			authencatedMenus = builder.buildMenu();
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}catch (Exception ee) {
			ee.printStackTrace();
		}
		return authencatedMenus;
	}
	
	@RequestMapping(value = "update/{id}")
	public String updateUi(HttpServletRequest request,@PathVariable Long id){
		Menu menu = new Menu();
		menu.setId(id);
		request.setAttribute("menu", menuService.query(menu));
		return MENU_UPDATE;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public @ResponseBody String update (HttpServletRequest request, Menu menu){
		menuService.update(menu);
		AjaxObject ajaxObject = new AjaxObject();
		ajaxObject.setCallbackType("closeCurrent");
		ajaxObject.setRel("jbsxBox2module");
		return ajaxObject.toString();
	}
	
	@RequestMapping(value = "delete/{id}",method = RequestMethod.POST)
	public @ResponseBody String delete (HttpServletRequest request, @PathVariable Long id){
		
		menuService.delete(id);
		AjaxObject ajaxObject = new AjaxObject();
		ajaxObject.setCallbackType("");
		ajaxObject.setRel("jbsxBox2module");
		return ajaxObject.toString();
	}
}
