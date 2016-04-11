<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>

<h2 class="contentTitle">修改用户</h2>
<form method="post" action="${ctx}/user/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<input type="hidden" name="id" value="${user.id}"/>
	<div class="pageFormContent" layoutH="97">
		<p>
			<label>登录名称:</label>
			<input type="text" name="username" class="required" size="20" maxlength="32" readonly="readonly" value="${user.username }"/>
		</p>
		<p>
			<label>登录密码:</label>
			<input type="text" name="password" class="required" size="20" minlength="6" maxlength="20" value="123456" alt="字母、数字、下划线 6-20位"/>
		</p>
		<p>
			<label>真实名字:</label>
			<input type="text" name="realname" class="required" size="20" maxlength="32" readonly="readonly" value="${user.realname }"/>
		</p>		
		<p>
			
			<label>生日:</label>
			<input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" class="date required" />
		</p>
		<p>
			<label>电话:</label>
			<input type="text" name="phone" class="phone" size="20" maxlength="64" value="${user.phone }"/>
		</p>
		<p>
			<label>用户邮箱:</label>
			<input type="text" name="email" class="email" size="20" maxlength="128" value="${user.email }"/>
		</p>		
		
		
			
	</div>
			
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>