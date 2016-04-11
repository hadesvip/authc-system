package com.cn.furious.service;

import javax.transaction.Transactional;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.cn.furious.model.User;
@Transactional
@Service
public class LoginService {


	public void login(User user){
		Subject subject = SecurityUtils.getSubject();
																//用户输入的用户名和密码
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
		subject.login(token);
	}
}
