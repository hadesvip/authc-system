package com.cn.furious.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.furious.dao.RoleDao;
import com.cn.furious.model.Role;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public Role queryRole(Role role){
		return roleDao.query(role);
	}
	
	public List<Role> getAll(){
		return roleDao.getAll();
	}

	public Long create(Role role) {
		roleDao.create(role);
		return role.getId();
	}

	public void update(Role role) {
		roleDao.update(role);
	}

	public void delete(Role role) {
		roleDao.delete(role.getId());
	}

	public void deletePermissions(Role role) {
		roleDao.deletePermissions(role);
	}
}
