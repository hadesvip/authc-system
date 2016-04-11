package com.cn.furious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.furious.dao.PermissionDao;
import com.cn.furious.model.Permission;
import com.cn.furious.model.Role;

@Service
public class PermissionService {

	@Autowired
	private PermissionDao dao;
	
	public List<Permission> getAll(){
		return dao.getAll();
	}
	
	public void create(List<Permission> permissions){
		for(Permission permission : permissions){
			dao.create(permission);
		}
	}

	public List<String> query(Role role) {
		List<String> permissions = dao.query(role.getId());
		return permissions;
	}
}
