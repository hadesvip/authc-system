package com.cn.furious.utils;

public enum GenderEnum {
	
	MAN("男",1),WOMEN("女",2);
	
	private String name;
	
	private Integer value;
	
	private GenderEnum(String name, Integer value){
		this.name  = name;
		this.value = value;
	}
	
	public String getName(){
		return this.name();
	}
	
	public Integer getValue(){
		return this.value;
	}
}
