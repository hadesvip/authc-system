package com.cn.furious.resource;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.cn.furious.model.User;
import com.cn.furious.service.LoginService;
import com.cn.furious.service.RegistService;

@Controller
@RequestMapping("/user")
public class RegistResource {
	private static final String LOGIN_UI  = "/core/login";
	private static final String REGIST_UI = "/core/regist";
	private static final String HOME = "/home";
	@Autowired
	private RegistService service;
	
	@Autowired
	private LoginService loginService;
	/**
	 * 注册页面
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registUi(){
		return REGIST_UI;
	}
	
//	@RequestMapping(value = "/regist", 
//					method = RequestMethod.POST,
//					consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//					produces = MediaType.APPLICATION_JSON_VALUE)
//	public String regist (User user){
//		try{
//			service.regist(user);
//		//注册失败
//		}catch(Exception e){
//			return REGIST_UI;
//		}
//		try{
//			loginService.login(user);
//		//登录失败
//		}catch(AuthenticationException e){
//			return LOGIN_UI;
//		}
//		return HOME;
//	}
	
	/**
	 * cookie
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/test",method = RequestMethod.GET)
	public void testCookie(HttpServletResponse response) throws IOException{
		Cookie cookie = new Cookie("key", "value"); 
		Integer expireTime = Integer.MAX_VALUE;
		cookie.setMaxAge(expireTime);
		response.addCookie(cookie);
		response.getWriter().write("success");
	}

}
