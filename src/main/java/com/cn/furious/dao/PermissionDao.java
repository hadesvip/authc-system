package com.cn.furious.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.furious.model.Permission;

public interface PermissionDao {

	List<Permission> getAll();

	void create(Permission permission);

	List<String> query(@Param("roleId")Long roleId);

}
