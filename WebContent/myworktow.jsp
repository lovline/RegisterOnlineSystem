<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>


<center>
	<br /> <br /> <br />
	<table width="600">
		<tr>
			<td><a href="${pageContext.request.contextPath}/mywork/"><b>所有任务</b></a></td>
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

		<c:forEach items="${cc}" var="cch" varStatus="li">
			<c:if test="${cch.status==1}">
				<form action="" method="post">
					<tr>
						<td width="200">${cch.deadline}</td>
						<td>${cch.detail}</td>
						<input type="hidden" name="work.number" value="${cch.id}" />
						<td width="150"><input type="submit" value="完成提交" /></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>

</center>
<%@ include file="../footer.jsp"%>