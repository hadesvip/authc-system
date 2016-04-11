<%@page import="java.util.Date"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="../base.jsp"%>
<script type="text/javascript">
<!--
// top
jQuery(document).ready(function(){
     
    $(".assignRole").click(function(){
    	var roleId = $(this).attr("id").split("submit_")[1];
    	var priority = $("#priority_" + roleId).val();
    
    	jQuery.ajax({
            type: 'POST',
            contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
            url: '<%=basePath %>/user/save_role/${userId}/'+roleId ,
            error: function() { 
            	 		alertMsg.error('分配角色失败！');
            		},
            success: function() { 
						// 删除已分配
            			var $remove = $("#roleRow_" + roleId).remove();
		            	var roleName = $remove.find("td").eq(0).text()
        		    	// 添加分配
            			$("#hasRoles").append("<tr><td>" + roleName + "</td><td>" + priority + "</td></tr>");
            		}		
            		
        });	
    });
    
});
//-->
</script>
<div class="pageContent" layoutH="0" >

	<fieldset>
		<legend>已分配角色</legend>
		<table class="list" width="100%">
			<thead>
		
			</thead>
			<tbody id="hasRoles">
				<c:forEach var="item" items="${userRoles}">
				<tr>
					<td>${item.roleName}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
	<fieldset>
		<legend>可分配角色</legend>
		<table class="list" width="100%">
			<thead>
			
			</thead>
			<tbody>
				<c:forEach var="item" items="${roles}">
				<%-- 不显示超级管理员角色，超级管理员只能拥有一个，且id=1 --%>
				
				<tr id="roleRow_${item.id}">
					<td>${item.roleName}</td>
					<td>
				
						<div class="button"><div class="buttonContent"><button id="submit_${item.id}" class="assignRole">分配</button></div></div>
					</td>
				</tr>					
					
				</c:forEach>
			</tbody>
		</table>
	</fieldset>
</div>

