package com.cn.furious.resource;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.furious.model.User;
import com.cn.furious.service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginResource {

	private static final String LOGIN_UI = "/core/login";
	private static final String HOME = "/home";

	@Autowired
	private LoginService loginService;
	
	/**
	 * 登陆页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String loginUi() {
		return LOGIN_UI;
	}
	
	/**
	 * 主页
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/home")
	public String home() {
		return HOME;
	}
	/**
	 * 登陆验证
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String login(User user, HttpServletSession session) {
		try{
			loginService.login(user);
			session.setAttribute("user", user);
		//登录失败
		}catch(AuthenticationException e){
			return LOGIN_UI;
		}
		return "redirect:/menu/list";
	}
	
//	/**  主页 **/
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public String index(){
//		return INDEX;
//	}
}
