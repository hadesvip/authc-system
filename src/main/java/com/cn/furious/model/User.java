package com.cn.furious.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cn.furious.json.param.UserFJB;
import com.cn.furious.utils.DateUtils;
/**
* @szj
* oneToMany one方式mappedBy对应的那个
*/
@Entity
@Table(name = "user")
public class User extends IdModel{
	
	public User(){
		
	}
	
	public User(UserFJB pbean){
		id		 = pbean.id;
		username = pbean.username;
		realname = pbean.realname;
		password = pbean.password;
		phone    = pbean.phone;
		email    = pbean.email;
		birthday = DateUtils.parseDate(pbean.birthday, DateUtils.PATTERN_THREE);
	}
	@Column(length=30)
	private String username;
	
	private String realname;
	
	@Column(length=30)
	private String password;
	
	@Column(length=30)
	private String phone;
	
	@Column(length=30)
	private String email;
	
	@Column(length=30)
	private Date birthday;

	private List<Role> roles;
	
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
