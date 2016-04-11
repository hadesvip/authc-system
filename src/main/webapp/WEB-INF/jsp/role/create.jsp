<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>

<h2 class="contentTitle">添加角色</h2>
<form method="post" action="${ctx }/role/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<div class="pageFormContent" layoutH="97">
	<dl>
		<dt>名称：</dt>
		<dd>
			<input type="text" name="roleName" class="required" size="30" maxlength="32" alt="请输入角色名称"/>
		</dd>
	</dl>
	<div class="divider"></div>
	<ul class="treeCustom">
		<li>
			<div class=""><div class="first_collapsable"></div><a href="#" class="permissionList">
				<span class="module_name">根模块</span>
				<span style="float: right;">
				<span class="crud">读取</span>
				<span class="crud">创建</span>
				<span class="crud">修改</span>
				<span class="crud">删除</span>
				<span class="crud">全部</span>
				</span>
			</a>
			</div>
			<ul>
				<c:set var="ind" value="${0}"/>
				<c:forEach var="m1" items="${module.children }" varStatus="m1ind">
					<div class=""><div class="indent"></div>
						<a href="#" class="permissionList">
							<span class="module_name">${m1.name }</span>
							<span class="inputValue">
							<input type="checkbox" name="permissionNames[${ind }]" value="${m1.authc }:view"/>
							<input type="checkbox" name="permissionNames[${ind }]" value="${m1.authc }:save"/>
							<input type="checkbox" name="permissionNames[${ind }]" value="${m1.authc }:edit"/>
							<input type="checkbox" name="permissionNames[${ind }]" value="${m1.authc }:delete"/>
							<input type="checkbox" class="checkboxCtrl" group="permissionNames[${ind }]" />
							</span>
						</a>
					</div>
					<ul>
						<c:forEach var="m2" items="${m1.children }" varStatus="m2ind">
						<c:set var="ind" value="${ind + 1 }"/>
							<div class=""><div class="indent"></div><div class="line"></div><div class="node"></div>
							<a href="#" class="permissionList">
								<span class="module_name">${m2.name }</span>
								<span class="inputValue">
								<input type="checkbox" name="permissionNames[${ind }]" value="${m2.authc }:view"/>
								<input type="checkbox" name="permissionNames[${ind }]" value="${m2.authc }:save"/>
								<input type="checkbox" name="permissionNames[${ind }]" value="${m2.authc }:edit"/>
								<input type="checkbox" name="permissionNames[${ind }]" value="${m2.authc }:delete"/>
								<input type="checkbox" class="checkboxCtrl" group="permissionNames[${ind }]" />
								</span>
							</a>
							</div>
						</li>
						</c:forEach>
					</ul>
				</li>
				<c:set var="ind" value="${ind + 1 }"/>
				</c:forEach>		
			</ul>
		</li>
	</ul>	

	</div>	
	
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>