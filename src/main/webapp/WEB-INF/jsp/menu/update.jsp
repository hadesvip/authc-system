<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>
<h2 class="contentTitle">修改组织</h2>
<form method="post" action="${ctx}/menu/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<input type="hidden" name="id" value="${menu.id}"/>
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>名称：</dt>
			<dd>
				<input type="text" name="name" class="required" size="32" maxlength="32" value="${menu.name }" />
			</dd>
		</dl>	
		<dl>
			<dt>优先级：</dt>
			<dd>
				<input type="text" name="priority" class="required" size="32" maxlength="32" value="${menu.priority}" />
			</dd>
		</dl>
		<dl>
			<dt>URL：</dt>
			<dd>
				<input type="text" name="url" class="required" size="32" maxlength="32" value="${menu.url}" />
			</dd>
		</dl>
		<dl>
			<dt>授权名称：</dt>
			<dd>
				<input type="text" name="authc" class="required" size="32" maxlength="32" value="${menu.authc}" />
			</dd>
		</dl>	
		<dl>
			<dt>描述：</dt>
			<dd>
				<textarea name="description" cols="32" rows="3" maxlength="255">${menu.description }</textarea>
			</dd>
		</dl>					
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>