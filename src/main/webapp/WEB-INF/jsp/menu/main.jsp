<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../base.jsp"%>

<div class="pageContent">
	<div class="tabs">

		<div class="tabsContent">
			<div>
				<div layoutH="0"
					style="float: left; display: block; overflow: auto; width: 240px; border: solid 1px #CCC; line-height: 21px; background: #fff">
					<ul class="tree treeFolder expand">
						<li><a href="<%=basePath %>/menu/list/0" target="ajax" rel="jbsxBox2module">${module.name }</a>
							<ul>
								<c:forEach var="level1" items="${menuModule}">
									<li><a href="<%=basePath %>menu/list/${level1.id}" target="ajax" rel="jbsxBox2module">${level1.name}</a>									
										<c:forEach var="level2" items="${level1.children }">
											<ul>
												<li><a href="<%=basePath %>menu/list/${level2.id}" target="ajax" rel="jbsxBox2module">${level2.name}</a></li>
											</ul>
										</c:forEach>
									</li>
								</c:forEach>
							</ul>
						</li>
					</ul>
				</div>

				<div id="jbsxBox2module" class="unitBox" style="margin-left: 246px;">
					<!--#include virtual="list1.html" -->
				</div>

			</div>
		</div>
	</div>
</div>
