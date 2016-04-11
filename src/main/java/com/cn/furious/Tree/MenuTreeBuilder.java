package com.cn.furious.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.cn.furious.model.Menu;
import com.cn.furious.model.Permission;

public class MenuTreeBuilder{
	
	private static final String VIEW = "view";
	
	private Tree tree;
	
	private Set<Permission> permissions;
	
	private List<Menu> menus;
	
	public List<INode> buildMenu(){
		if(CollectionUtils.isEmpty(menus)
				|| CollectionUtils.isEmpty(permissions)){
			throw new IllegalArgumentException();
		}
		
		List<String> permissionNames = getNames(permissions);
		List<Menu> authencatedMenus = new ArrayList<>();
		for(Menu menu : menus){
			if(permissionNames.contains(menu.getAuthc() + ":" + VIEW)){
				authencatedMenus.add(menu);
			}
		}
		tree = new Tree(authencatedMenus);
		return tree.buildTree();
	}

	public void init(Set<Permission> permissions, List<Menu> menus){
		this.permissions = permissions;
		this.menus = menus;
	}
	
	private List<String> getNames(Set<Permission> permissions){
		List<String> names = new ArrayList<>();
		for(Permission permission : permissions){
			names.add(permission.getPermissionName());
		}
		return names;
	}
}
