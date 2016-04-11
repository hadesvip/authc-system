package com.cn.furious.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.furious.model.Menu;

public interface MenuDao {
	
	Menu query(Menu menu);
	
	List<Menu> queryChildren(Menu menu);
	
	List<Menu> getAll();
	
	void create (Menu menu);

	void delete(@Param("id")Long id);
	
	void deleteIncludeChildren(@Param("id")Long id);

	void update(Menu menu);
}
