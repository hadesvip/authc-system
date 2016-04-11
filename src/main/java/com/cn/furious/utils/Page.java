package com.cn.furious.utils;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author szj
 */
public class Page {

	private Integer pageId = 1; // 当前页
	
	private Long rowCount; // 数据库总行数
	
	private Integer pageSize = 10; // 默认页大小
	
	private Long pageCount; // 总页数
	
	private Long pageOffset;// 当前页起始记录
	
	private Long pageTail;// 当前页到达的记录
	
	private String orderField; //排序
	
	private boolean orderDirection; //true:asc, false:desc

	//constructor
	public Page() {
		orderDirection = true;
	}
	
	public String produce() {
		
		//check if parameters valid
		if(!checkIfValid(rowCount, pageId, pageSize))
			throw new IllegalArgumentException();
		
		//计算总页数
		pageCount = rowCount / pageSize + 1;	
		if ((rowCount % pageSize == 0) && pageCount > 1){
			pageCount--;
		}

		//如果有11条数据,pageTail=10时,下一次计算pageTail应该是11而不是15
		pageOffset = (long) ((pageId - 1) * pageSize);
		pageTail = pageOffset + pageSize;
		if ((pageTail + pageSize) > rowCount){
			pageTail = rowCount;
		}		
		return getOrderCondition() + getMysqlQueryCondition();
	}
	
	//检验参数有效性
	private boolean checkIfValid(Long rowCount, Integer pageId,Integer pageSize){
		
		if((rowCount > 0)
			&&(pageId > 0)
			&&(pageSize > 0)){
			return true;
		}else{
			return false;
		}
	}
	
	public Page setRowCount(Long rowCount){
		this.rowCount = rowCount.longValue();
		return this;
	}
	
	public Page setPageNumber(Integer pageNumber){
		this.pageId = pageNumber.intValue();
		return this;	
	}
	
	public Page setPageSize(Integer pageSize){
		this.pageSize = pageSize.intValue();
		return this;
	}
	
	public Page setOrderField(String orderField){
		this.orderField = orderField;
		return this;
	}
	
	public Page setOrderDirection(boolean orderDirection){
		this.orderDirection = orderDirection;
		return this;
	}
	
	//orderBy xml占位符
	//排序默认asc
	public String getOrderCondition() {
		String condition = "";
		if (orderField != null && orderField.length() != 0) {
			condition = " order by " + orderField
					+ (orderDirection ? " " : " desc ");
		}
		return condition;
	}

	//limit和offset xml占位符
	public String getMysqlQueryCondition() {
		String pageField = "";
		pageField = " limit " + pageOffset + "," + pageSize;
		return pageField;
	}

	public boolean isOrderDirection() {
		return orderDirection;
	}

	public String getOrderField() {
		return orderField;
	}

	public Integer getPageId() {
		return pageId;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Long getRowCount() {
		return rowCount;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public Long getPageOffset() {
		return pageOffset;
	}

	public Long getPageTail() {
		return pageTail;
	}
}