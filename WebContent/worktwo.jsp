<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
	<b>分配工作</b>
<div style="width: 600; float: right">
	<br /> <br /> <br />
	<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/work/"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新增&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/workthree/"><b>处理中任务</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/workupdate/"><b>被拒绝任务</b></a>
</div>
<center>
	<br /> <br /> <br />
	<table class="table table-bordered">
		<tr class="bg-primary" align="center" >
			<b>
				<td>编号</td>
				<td>添加时间</td>
				<td>工作</td>
				<td>操作</td>
			</b>
		</tr>

		<c:forEach items="${cc}" var="ch" varStatus="list">
			<c:if test="${ch.assignee_id==0}">
				<form action="" method="post">
					<tr class="bg-success" align="center" height="30">
						<td width="50">${list.index+1}</td>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="200"><select name="custId">
								<option value="">选择员工</option>
								<c:forEach items="${cu}" var="u">
									<option value="${ u.id }">${u.realname}</option>
								</c:forEach>
						</select> <input type="hidden" name="worknum" value="${ch.id}" /> <input
							type="hidden" name="userid" value="${ch.user.id}" /> &nbsp;&nbsp;&nbsp;&nbsp;<input
							type="submit" value="分配" class="btn btn-warning" /></td>
					</tr>
				</form>
			</c:if>
			<c:if test="${ch.assignee_id!=0&&ch.status==4}">
			<tr class="bg-success" align="center" >
						<td width="50">${list.index+1}</td>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="200"><b for="exampleInputEmail1">已分配</b><kbd>${ch.assignee.realname}</kbd></td>
					</tr>
			</c:if>
			<c:if test="${ch.status==4&&ch.assignee_id!=0}">
				<tr class="bg-success" align="center" >
					<td width="50">${list.index+1}</td>
						<td width="200">${ch.deadline}</td>
						<td>${ch.detail}</td>
						<td width="200">完成</td>
				</tr>
			</c:if>
			
			
		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>