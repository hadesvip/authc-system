package com.cn.furious.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.furious.dao.MenuDao;
import com.cn.furious.model.Menu;

@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;
	
	public void create(Menu menu){
		menuDao.create(menu);
	}
	
	public List<Menu> getAll(){
		return menuDao.getAll();
	}
	
	public Menu query(Menu menu){
		return menuDao.query(menu);
	}
	
	public List<Menu> queryChildren(Menu menu){
		return menuDao.queryChildren(menu);
	}

	@Transactional
	public void delete(Long id) {
		Menu menu0 = new Menu();
		menu0.setId(id);
		if(!CollectionUtils.isEmpty(menuDao.queryChildren(menu0))){
			menuDao.deleteIncludeChildren(id);
			return;
		}
		menuDao.delete(id);
	}
	
	public void update(Menu menu){
		menuDao.update(menu);
	}
}
