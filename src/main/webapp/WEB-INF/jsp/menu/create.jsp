<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>
<h2 class="contentTitle">添加模块</h2>
<form method="post" action="<%=basePath %>/menu/create" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<input type="hidden" id="createParentId" name="parentId" />
	<script type="text/javascript">
		document.getElementById("createParentId").value = document.getElementById("parentId").value;
	</script>
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>名称：</dt>
			<dd>
				<input type="text" name="name" class="required" size="32" maxlength="32"  alt="请输入模块名称"/>
			</dd>
		</dl>
		<dl>
			<dt>优先级：</dt>
			<dd>
				<input type="text" name="priority" class="required digits" size="2"  maxlength="2"/>
				<span class="info">&nbsp;&nbsp;默认:99</span>
			</dd>
		</dl>		
		<dl>
			<dt>URL：</dt>
			<dd>
				<input type="text" name="url" class="required" size="32" maxlength="255"  alt="请输入访问地址"/>
			</dd>
		</dl>
		<dl>
			<dt>授权名称：</dt>
			<dd>
				<input type="text" name="authc" class="required" size="32" maxlength="32"  alt="授权名称"/>
			</dd>
		</dl>		
		<dl>
			<dt>描述：</dt>
			<dd>
				<textarea name="description" cols="32" rows="3" maxlength="255"></textarea>
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