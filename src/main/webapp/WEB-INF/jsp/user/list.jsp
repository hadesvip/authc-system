<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>
<form id="pagerForm" method="post" action="${ctx }/user/list">
	<input type="hidden" name="pageNum" value="${page.pageNum}" />
	<input type="hidden" name="numPerPage" value="${page.numPerPage}" /> 
	<input type="hidden" name="orderField" value="${page.orderField}" />
	<input type="hidden" name="orderDirection" value="${page.orderDirection}" />
	 
	<input type="hidden" name="keywords" value="${keywords}"/>
</form>

<form method="post" action="${ctx }/user/list" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label>角色名称：</label>
					<input type="text" name="keywords" value="${keywords}"/>
				</li>
			</ul>
			<div class="subBar">
				<ul>						
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<shiro:hasPermission name="User:save">
				<li><a class="add" target="dialog" mask="true" width="500" height="500" href="${ctx }/user/create" ><span>添加</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="User:edit">
				<li><a class="edit" target="dialog" mask="true" width="500" height="500" href="${ctx }/user/update/{slt_uid}" ><span>编辑</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="User:edit">
				<li><a class="edit" target="dialog" mask="true" width="500" height="500" href="${ctx }/user/distribute_roles/{slt_uid}" ><span>分配权限</span></a></li>
			</shiro:hasPermission>
			<shiro:hasPermission name="User:delete">
				<li><a class="delete" target="ajaxTodo" href="${ctx }/user/delete/{slt_uid}" title="确认要删除该角色?"><span>删除</span></a></li>
			</shiro:hasPermission>
		</ul>
	</div>
	
	<table class="table" layoutH="138" width="100%">
		<thead>
			<tr>
				<th width="200">用户名</th>
				<th width="200">生日</th>
				<th width="200">邮箱</th>
				<th width="200">密码</th>
				<th width="200">电话</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${users}">
			<tr target="slt_uid" rel="${item.id}">
				<td>${item.username}</td>
				<td><fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd"/></td>
				<td>${item.email}</td>
				<td>${item.password}</td>
				<td>${item.phone}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	

</div>


