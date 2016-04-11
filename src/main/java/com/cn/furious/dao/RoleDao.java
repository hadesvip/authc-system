package com.cn.furious.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.furious.model.Role;

public interface RoleDao {
	
	Role query(Role role);

	List<Role> getAll();

	void create(Role role);

	void update(Role role);

	void delete(@Param("id")Long id);

	void deletePermissions(Role role);
}
