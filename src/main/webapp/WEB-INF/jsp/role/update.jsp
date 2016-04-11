<%@page import="com.cn.furious.model.Role"%>
<%@page import="com.cn.furious.model.Menu"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>

<h2 class="contentTitle">修改角色</h2>
<form method="post" action="<%=basePath %>/role/update" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<input type="hidden" name="id" value="${role.id }">
	<div class="pageFormContent" layoutH="97">
	<dl>
		<dt>名称：</dt>
		<dd>
			<input type="text" name="roleName" value="${role.roleName }" class="required" size="32" maxlength="32" alt="请输入角色名称" value="${role.roleName }"/>
		</dd>
	</dl>
	
	<div class="divider"></div>
	
	<ul class="treeCustom">
		<li>
			<div class=""><div class="first_collapsable"></div>
			<a href="#" class="permissionList">
				<span class="module_name">${module.name }</span>
				<span style="float: right;">
				<span class="crud">读取</span>
				<span class="crud">创建</span>
				<span class="crud">修改</span>
				<span class="crud">删除</span>
				<span class="crud">全部</span>
				</span>
			</a>
			</div>
			<%
				Role role = (Role)request.getAttribute("role");
				List<String> permissionList = role.getPermissionNames();
				
				Menu module = (Menu)request.getAttribute("module");
				int ind = 0;
				out.println("<ul>");
				for (int m1ind = 0; m1ind < module.getChildren().size(); m1ind++) {
					Menu m1 = module.getChildren().get(m1ind);
					if ((m1ind + 1) == module.getChildren().size()) {
						out.println("			<li class=\"last\">");	
					} else {
						out.println("			<li>");
					}
					out.println("<div class=\"\"><div class=\"indent\"></div>");
					
					if (m1.getChildren().size() > 0) {
						out.println("<div class=\"collapsable\"></div>");
					} else {
						out.println("<div class=\"node\"></div>");
					}
					
					out.println("		<a href=\"#\" class=\"permissionNames\">");
					out.println("<span class=\"module_name\">" + m1.getName() + "</span>");
					out.println("<span class=\"inputValue\">");
						
					if (permissionList.contains(m1.getAuthc() + ":view")) {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":view\" checked=\"checked\"/>");	
					} else {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":view\" />");
					}
				
					if (permissionList.contains(m1.getAuthc() + ":save")) {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":save\" checked=\"checked\"/>");	
					} else {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":save\" />");
					}
					
					if (permissionList.contains(m1.getAuthc() + ":edit")) {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":edit\" checked=\"checked\"/>");	
					} else {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":edit\" />");
					}
					
					if (permissionList.contains(m1.getAuthc() + ":delete")) {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":delete\" checked=\"checked\"/>");	
					} else {
						out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m1.getAuthc() + ":delete\" />");
					}
					
					if (permissionList.contains(m1.getAuthc() + ":view") && permissionList.contains(m1.getAuthc() + ":save") 
							&& permissionList.contains(m1.getAuthc() + ":edit") && permissionList.contains(m1.getAuthc() + ":delete")) {
						out.println("	<input type=\"checkbox\" class=\"checkboxCtrl\" group=\"permissionNames[" + ind + "]\" checked=\"checked\"/>");	
					} else {
						out.println("	<input type=\"checkbox\" class=\"checkboxCtrl\" group=\"permissionNames[" + ind + "]\" />");
					}
					out.println("</span>");
					out.println("		</a>");
					out.println("		</div>");
					
					if (!m1.getChildren().isEmpty()) {
						out.println("		<ul>");
						for (int m2ind = 0; m2ind < m1.getChildren().size(); m2ind++) {
							ind++;
							Menu m2 = m1.getChildren().get(m2ind);
							if ((m2ind + 1) == m1.getChildren().size()) {
								out.println("			<li class=\"last\">");	
							} else {
								out.println("			<li>");
							}
							
							out.println("<div class=\"\"><div class=\"indent\"></div><div class=\"line\"></div><div class=\"node\"></div>");
							out.println("		<a href=\"#\" class=\"permissionNames\">");
							out.println("<span class=\"module_name\">" + m2.getName() + "</span>");
							out.println("<span class=\"inputValue\">");
							
							if (permissionList.contains(m2.getAuthc() + ":view")) {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":view\" checked=\"checked\"/>");	
							} else {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":view\" />");
							}
							
							if (permissionList.contains(m2.getAuthc() + ":save")) {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":save\" checked=\"checked\"/>");	
							} else {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":save\" />");
							}
							
							if (permissionList.contains(m2.getAuthc() + ":edit")) {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":edit\" checked=\"checked\"/>");	
							} else {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":edit\" />");
							}
							
							if (permissionList.contains(m2.getAuthc() + ":delete")) {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":delete\" checked=\"checked\"/>");	
							} else {
								out.println("	<input type=\"checkbox\" name=\"permissionNames[" + ind + "]\" value=\"" + m2.getAuthc() + ":delete\" />");
							}
							
							if (permissionList.contains(m2.getAuthc() + ":view") && permissionList.contains(m2.getAuthc() + ":save") 
									&& permissionList.contains(m2.getAuthc() + ":edit") && permissionList.contains(m2.getAuthc() + ":delete")) {
								out.println("	<input type=\"checkbox\" class=\"checkboxCtrl\" group=\"permissionNames[" + ind + "]\" checked=\"checked\"/>");	
							} else {
								out.println("	<input type=\"checkbox\" class=\"checkboxCtrl\" group=\"permissionNames[" + ind + "]\" />");
							}
							out.println("</span>");
							out.println("		</a>");
							out.println("</div>");
							out.println("			</li>");
						}
						out.println("		</ul>");
					}
					out.println("	</li>");
					ind++;	
				}
				out.println("</ul>");
			%>
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