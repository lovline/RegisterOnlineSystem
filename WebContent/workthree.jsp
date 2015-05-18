<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<b>分配工作</b>
<div style="width: 600; float: right">
	<br /> <br /> <br />
	<a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/work/"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/worktwo/"><b>查看分配</b></a>
</div>
<center>
	<br /> <br /> <br />
	<table width="600" class="table table-bordered">
		<tr class="bg-primary">
			<b>
				<td>编号</td>
				<td>时间</td>
				<td>员工</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="ch" varStatus="list">
			<c:if test="${ch.status!=0}">
				<form action="" method="post">
					<tr class="bg-success">
						<td width="50">${ list.index+1 }</td>
						<td width="200">${ch.deadline}</td>
									<td>${ch.assignee.realname}</td>
						<td>${ch.detail}</td>
						<td width="200"><c:if test="${ch.status==4}">完成</c:if> <c:if
								test="${ch.status==1}">已经接受</c:if> <c:if test="${ch.status==2}">拒绝</c:if>
							<c:if test="${ch.status==3}">
								<input type="hidden" name="worknum2" value="${ch.id}" />
								<input type="submit" value="关闭 " class="btn btn-warning" />
							</c:if></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>