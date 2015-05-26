<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<b>处理工作</b>
<div style="width: 600; float: right">
	<br /> <br /> <br /> <a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/work/"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/worktwo/"><b>查看分配/已完成</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/workthree/"><b>处理中任务</b></a>
</div>
<center>
	<br /> <br /> <br />
	<table width="600" class="table table-bordered">
		<tr class="bg-primary" align="center">
			<b>
				<td>员工提交时间</td>
				<td>员工</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="ch" varStatus="libi">
			<c:if test="${ch.status==2}">
				<form action="" method="post">
					<tr class="bg-success" align="center">
						<td width="200">${ch.created_at}</td>
						<td>${ch.assignee.realname}</td>
						<td>${ch.detail}</td>
						<td width="200">拒绝&nbsp;&nbsp;&nbsp; <input type="hidden"
							name="cf" value="${ch.id}" /> <input type="submit" value="重新分配"
							class="btn btn-warning" />
						</td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>