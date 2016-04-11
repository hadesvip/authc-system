package com.cn.furious.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cn.furious.Tree.INode;

@Entity
@Table(name = "menu")
public class Menu extends IdModel implements INode{

	@Column(length = 30)
	private String name;
	
	@Column(length = 30)
	private String url;

	@Column(length = 30)
	private String description;

	@Column(length = 30)
	private String authc;
	
	@Column(length=2)
	private Integer priority;
	
	private Long parentId;

	private List<Menu> children = new ArrayList<>();

	private String parentName;
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthc() {
		return authc;
	}

	public void setAuthc(String authc) {
		this.authc = authc;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	@Override
	public void addChild(INode n) {
		Menu menu = (Menu)n;
		this.children.add(menu);
	}

	@Override
	public Long getPid() {
		return parentId;
	}
	
	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Override
	public String getIcon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIcon(String icon) {
		// TODO Auto-generated method stub
		
	}
}
