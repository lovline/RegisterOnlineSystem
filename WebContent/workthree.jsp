<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<<<<<<< HEAD
<div style="width: 600">
	<b>分配工作</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
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
				<td>用户</td>
=======
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
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="ch" varStatus="list">
			<c:if test="${ch.status!=0}">
				<form action="" method="post">
<<<<<<< HEAD
					<tr class="bg-success">
						<td>${ list.index }</td>
						<td width="200">${ch.deadline}</td>
						<td>${ch.name}</td>
						<td>${ch.detail}</td>

						<td width="200"><c:if test="${ch.status==4}">完成</c:if> <c:if
								test="${ch.status==1}">已经接受</c:if> <c:if test="${ch.status==2}">拒绝</c:if>
							<c:if test="${ch.status==3}">
								<input type="hidden" name="worknum2" value="${ch.id}" />
								<input type="submit" value="关闭 " class="btn btn-warning" />
=======
					<tr>
						<td height="30">${ list.count }</td>
						<td width="150">${ch.deadline}</td>
						<td>${ch.detail}</td>

							<td>
							<c:if test="${ch.status==4}">完成</c:if> <c:if
								test="${ch.status==1}">已经接受</c:if> <c:if test="${ch.status==2}">拒绝</c:if>
							<c:if test="${ch.status==3}"><input type="hidden" name="worknum2" value="${ch.id}" />
								<input type="submit" value="关闭 " />
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
							</c:if></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>