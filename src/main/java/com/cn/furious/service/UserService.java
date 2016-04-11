package com.cn.furious.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.furious.dao.UserDao;
import com.cn.furious.model.Role;
import com.cn.furious.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User query (User user){
		return userDao.query(user);
	}
	
	public List<User> getAll(){
		return userDao.getAll();
	}
	
	public User queryById(Long id){
		return userDao.queryById(id);
	}

	public void create(User user) {
		userDao.create(user);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public void delete(Long id) {
		userDao.delete(id);
	}

	public List<Role> queryRoles(Long userId) {
		return userDao.queryRoles(userId);
	}

	public void saveRole(Long userId, Long roleId) {
		Map<String,Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("roleId", roleId);
		userDao.saveRole(map);
	}
}
