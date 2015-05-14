<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div class="row">
	<h1>查看工作</h1>
</div>
<center>
	<br /> <br /> <br />
	<table width="600">
		<tr>
			<td><a href="${pageContext.request.contextPath}/work/"><b>新增</b></a>____<a
				href="${pageContext.request.contextPath}/workthree/"><b>已接任务</b></a></td>
		</tr>
	</table>
	<table width="600" border="1">
		<tr>
			<b>
				<td>时间</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="ch" varStatus="list">
			<c:if test="${ch.assignee_id==0}">
				<form action="" method="post">
					<tr>
						<td width="150">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="150"><select name="custId">
								<option>选择客户</option>
								<c:forEach items="${cu}" var="u">
									<option value="${ u.id }">${u.realname}</option>
								</c:forEach>
						</select> <input type="hidden" name="worknum" value="${ch.id}" /> <input
							type="hidden" name="userid" value="${ch.user.id}" /> <input
							type="submit" value="分配" /></td>
					</tr>
				</form>
			</c:if>

			<c:if test="${ch.assignee_id!=0}">
				<tr>
					<td width="150">${ch.deadline}</td>
					<td>${ch.detail}</td>
					<td width="150">已分配</td>
				</tr>
			</c:if>

		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>