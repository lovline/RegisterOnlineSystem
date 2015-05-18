<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div style="width: 600">
	<b>我接受的工作</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/mywork/"><b>所有任务</b></a>
</div>

<center>
	<br /> <br /> <br />
	<table width="600" class="table table-bordered">
		<tr class="bg-primary">
			<b>
				<td>时间</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="cch" varStatus="li">
			<c:if test="${cch.status==1}">
				<form action="" method="post">
					<tr class="bg-success">
						<td width="200">${cch.deadline}</td>
						<td>${cch.detail}</td>
						<input type="hidden" name="work.number" value="${cch.id}" />
						<td width="200"><input type="submit" value="完成提交"
							class="btn btn-warning" /></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>

</center>
<%@ include file="../footer.jsp"%>