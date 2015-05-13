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
			<td><a href="${pageContext.request.contextPath}/work/"><b>新增</b></a>____<a href="${pageContext.request.contextPath}/worktwo/"><b>查看分配</b></a></td>
		</tr>
	</table>
	<table width="600" border="1">
		<tr>
			<b>
				<td>编号</td>
				<td>时间</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="ch" varStatus="list">
			<c:if test="${ch.status!=0}">
				<form action="" method="post">
					<tr>
						<td height="30">${ list.count }</td>
						<td width="150">${ch.deadline}</td>
						<td>${ch.detail}</td>

							<td>
							<c:if test="${ch.status==4}">完成</c:if> <c:if
								test="${ch.status==1}">已经接受</c:if> <c:if test="${ch.status==2}">拒绝</c:if>
							<c:if test="${ch.status==3}"><input type="hidden" name="worknum2" value="${ch.id}" />
								<input type="submit" value="关闭 " />
							</c:if></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>