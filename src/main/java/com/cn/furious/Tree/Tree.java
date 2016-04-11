package com.cn.furious.Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
	
	private List<INode> jsonArray = new ArrayList<INode>();
	
	private List<INode> iNodeList = new ArrayList<INode>();

	public Tree(List<? extends INode> iNodeList){
		this.iNodeList = (List<INode>) iNodeList;
	}
	
	public List<INode> buildTree(){
		for(INode iNode : iNodeList){
			if(null == iNode.getPid() || iNode.getPid().longValue() == 0){
				jsonArray.add(iNode);
				buildINode(iNode);
			}
		}
		return jsonArray;
	}

	private void buildINode(INode iNode) {
		List<INode> childrenList = getChildren(iNode);
		if(!childrenList.isEmpty()){
			for(INode n : childrenList){
				iNode.addChild(n);
				buildINode(n);
			}
		}
	}
	
	private List<INode> getChildren(INode iNode){
		List<INode> childrenList = new ArrayList<INode>();
		for(INode child : iNodeList){
			if(iNode.getId().equals(child.getPid())){
				childrenList.add(child);
			}
		}
		return childrenList;
	}
}
