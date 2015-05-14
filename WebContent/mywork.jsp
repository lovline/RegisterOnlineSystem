<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>



<center>
	<br /> <br /> <br />
	<table width="600">
		<tr>
			<td><a href="${pageContext.request.contextPath}/myworktow/"><b>已接任务</b></a></td>
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
				<!-- 0: 正常 -->
				<c:if test="${ch.status==0}">
					<form action="" method="post">
						<tr>
							<td width="200">${ch.deadline}</td>
							<td>${ch.detail}</td>
							<td width="150"><select name="custId">
									<option value="">选择</option>
									<option value="1">接受</option>
									<option value="2">拒绝</option>
							</select> <input type="hidden" name="workid" value="${ch.id}" /> <input
								type="submit" value="提交" /></td>
						</tr>
					</form>
				</c:if>
				<!--  1：已经接受 -->
				<c:if test="${ch.status==1}">
					<tr>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="150">已接</td>
					</tr>
				</c:if>
				<!--2: 拒绝 -->
				<c:if test="${ch.status==2}">
					<tr>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="150">拒绝</td>
					</tr>
				</c:if>
				<!--  3：完成待验收 -->
				<c:if test="${ch.status==3}">
					<tr>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="150">完成待验收</td>
					</tr>
				</c:if>
				<!--  4:完成 -->
				<c:if test="${ch.status==4}">
					<tr>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="150">完成</td>
					</tr>
				</c:if>

		</c:forEach>

	</table>


</center>
<%@ include file="../footer.jsp"%>