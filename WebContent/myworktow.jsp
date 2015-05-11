<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div class="row">
	<b><a href="../mywork.jsp">所有任务</a></b>/<b><a href="../mywork.jsp">已接任务</a></b>
</div>
<br /><br />

<center>
	<table width="600" border="1">
		<tr>
			<b>
				<td>时间</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>
		<c:forEach items="${cc}" var="ch" varStatus="list">
			<c:if test="${ch.status==0}">
				<form action="" method="post">
					<tr>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="150">
						<select name="custId">
								<option value="">选择</option>
								<option value="1">接受</option>
								<option value="2">拒绝</option>
						</select> 
						<input type="hidden" name="workid" value="${ch.id}" />
						<input type="submit" value="提交" /></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>
	<br /> <br /> <br />
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
						<input type="hidden" name="work.number" value="${3}" />
						<td width="150"><input type="submit" value="完成提交" /></td>
					</tr>
				</form>
			</c:if>
		</c:forEach>
	</table>

</center>
<%@ include file="../footer.jsp"%>