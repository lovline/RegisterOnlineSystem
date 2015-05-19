<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>

	<b>我的所有工作</b><div style="width: 600; float:right">
<br /> <br /> <br /><a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/myworktow/"><b>查看已接任务</b></a>
</div>


<center>
	<br /> <br /> <br />
	<table width="600" class="table table-bordered">
		<tr class="bg-primary" align="center" >
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
					<tr class="bg-success" align="center" >
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="200"><select name="custId">
								<option value="">&nbsp;&nbsp;选择&nbsp;&nbsp;</option>
								<option value="1">&nbsp;&nbsp;接受&nbsp;&nbsp;</option>
								<option value="2">&nbsp;&nbsp;拒绝&nbsp;&nbsp;</option>
						</select> <input type="hidden" name="workid" value="${ch.id}" /> <input
							type="submit" value="提交" class="btn btn-warning" /></td>
					</tr>
				</form>
			</c:if>
			<!--  1：已经接受 -->
			<c:if test="${ch.status==1}">
				<tr class="bg-success" align="center" >
					<td width="200">${ch.deadline}</td>
					<td>${ch.detail}</td>
					<td width="150">已接</td>
				</tr>
			</c:if>
			<!--2: 拒绝 -->
			<c:if test="${ch.status==2}">
				<tr class="bg-success" align="center" >
					<td width="200">${ch.deadline}</td>
					<td>${ch.detail}</td>
					<td width="150">拒绝</td>
				</tr>
			</c:if>
			<!--  3：完成待验收 -->
			<c:if test="${ch.status==3}">
				<tr class="bg-success" align="center" >
					<td width="200">${ch.deadline}</td>
					<td>${ch.detail}</td>
					<td width="150">完成待验收</td>
				</tr>
			</c:if>
			<!--  4:完成 -->
			<c:if test="${ch.status==4}">
				<tr class="bg-success" align="center" >
					<td width="200">${ch.deadline}</td>
					<td>${ch.detail}</td>
					<td width="150">完成</td>
				</tr>
			</c:if>

		</c:forEach>

	</table>


</center>
<%@ include file="../footer.jsp"%>