package com.cn.furious.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role extends IdModel{

	@Column(length = 30)
	private String roleName;

	private List<Permission> permissions;
	
	private List<String> permissionNames;
	
	public List<String> getPermissionNames() {
		return permissionNames;
	}

	public void setPermissionNames(List<String> permissionNames) {
		this.permissionNames = permissionNames;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
