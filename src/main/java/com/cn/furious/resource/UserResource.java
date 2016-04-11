package com.cn.furious.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.furious.json.param.UserFJB;
import com.cn.furious.json.result.AjaxObject;
import com.cn.furious.model.Role;
import com.cn.furious.model.User;
import com.cn.furious.service.RoleService;
import com.cn.furious.service.UserService;


@Controller
@RequestMapping("/user")
public class UserResource {

	private final static String USER_LIST = "/user/list";
	private final static String USER_CREATE = "/user/create";
	private final static String USER_UPDATE = "/user/update";
	private final static String USER_DISTRIBUTE_ROLES = "/user/distributeRoles";
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value = "/list")
	public String userList(HttpServletRequest request){
		
		request.setAttribute("users",  userService.getAll());
		return USER_LIST;
	}
	
	@RequestMapping(value = "/create")
	public String createUi(HttpServletRequest request){

		return USER_CREATE;
	}
	
	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public @ResponseBody String create(HttpServletRequest request,UserFJB pbean){
		
		User user = new User(pbean);
		userService.create(user);
		
		AjaxObject obj = new AjaxObject();
		obj.setCallbackType("closeCurrent");
		return obj.toString();
	}
	
	
	@RequestMapping(value = "/update/{id}")
	public String updateUi(HttpServletRequest request,@PathVariable Long id){
		
		User user = userService.queryById(id);
		request.setAttribute("user", user);
		return USER_UPDATE;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String update(HttpServletRequest request, UserFJB pbean){
		
		User user = new User(pbean);
		userService.update(user);
		
		AjaxObject obj = new AjaxObject();
		obj.setCallbackType("closeCurrent");
		return obj.toString();
	}
	
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody String delete(HttpServletRequest request,@PathVariable Long id){
		
		userService.delete(id);
		AjaxObject obj = new AjaxObject();
		obj.setCallbackType("");
		return obj.toString();
	}
	
	@RequestMapping(value = "/distribute_roles/{userId}",method = RequestMethod.GET)
	public String distributeRoles(HttpServletRequest request,@PathVariable Long userId){
		
		List<Role> hasRoles = userService.queryRoles(userId);
		List<Role> allRoles = roleService.getAll();
		Map<Long,Object> map = new HashMap<>();
		for(Role role : allRoles){
			map.put(role.getId(), role);
		}
		for(Role hasRole : hasRoles){
			if(map.get(hasRole.getId()) != null){
				map.remove(hasRole.getId());
			}
		}
		List<Role> dosentHasRoles = new ArrayList<>();

		for(Map.Entry<Long, Object> entry : map.entrySet()){
			dosentHasRoles.add((Role)entry.getValue());
		}
		request.setAttribute("userRoles", hasRoles);
		request.setAttribute("roles", dosentHasRoles);
		
		request.setAttribute("userId", userId);
		return USER_DISTRIBUTE_ROLES;
	}

	@RequestMapping(value="/save_role/{userId}/{roleId}", method={RequestMethod.POST})
	public @ResponseBody void saveRole(HttpServletRequest request,@PathVariable Long userId,@PathVariable Long roleId) {
		userService.saveRole(userId,roleId);
	}
}
