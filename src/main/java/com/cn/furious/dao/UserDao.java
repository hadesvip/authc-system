package com.cn.furious.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.furious.model.Role;
import com.cn.furious.model.User;

public interface UserDao {
	
	User query(User user);
	
	User queryById(@Param("id")Long id);
	
	List<User> getAll();

	void create(User user);

	void update(User user);

	void delete(@Param("id")Long id);

	List<Role> queryRoles(@Param("userId")Long userId);

	void saveRole(Map<String, Object> map);

}
