package com.cn.furious.json.param;

import javax.persistence.Column;

public class UserFJB {
	public Long id;
	
	@Column(length=30)
	public String username;
	
	public String realname;
	
	@Column(length=30)
	public String password;
	
	@Column(length=30)
	public String phone;
	
	@Column(length=30)
	public String email;
	
	@Column(length=30)
	public String birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	
}
