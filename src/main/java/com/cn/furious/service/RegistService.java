package com.cn.furious.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.furious.dao.UserDao;
import com.cn.furious.model.User;
@Transactional
@Service
public class RegistService {
	
	private static final Logger logger = Logger.getLogger(RegistService.class);
//
//	@Autowired
//	private UserDao userDao;
//	
//	public void regist(User user){
//		Integer amount = userDao.count(user);
//		if(amount > 0){
//			throw new RuntimeException();
//		}
//		userDao.presist(user);
//	}
}
