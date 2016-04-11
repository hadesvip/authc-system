package com.cn.furious.Tree;

import java.util.List;

public interface INode {

	 String getName();

	 Long getId();
	
	 void addChild(INode n);
	
	 Long getPid();

	 String getUrl();
	 
	 void setUrl(String url);

	 String getIcon();
	 
	 void setIcon(String icon);
	 
	 List<? extends INode> getChildren(); 
}
