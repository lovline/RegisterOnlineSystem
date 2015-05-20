<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
	<b>请假管理——批准/记录</b>
	<br><br><br>
<div style="width: 600; float: right"><a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/absencetwo/"><b>待销假信息</b></a></div>
<div><br><br>
	<table align="center" class="table table-bordered">
		<tr class="bg-primary">
			<th>姓名</th>
			<th>申请时间</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>请假操作</th>
		</tr>
		<c:forEach items="${results}" var="result">

				<tr class="bg-success">
					<td>${result.name}</td>
					<td>${result.created_at}</td>
					<td>${result.start_time}</td>
					<td>${result.end_time}</td>
					<form method="post" action="">
					<td><c:if test="${result.status == 1}">
							<select name="z">
								<option value="">选择</option>
								<option value="2">批准</option>
								<option value="3">拒绝</option>
							</select>
							<input type="hidden" name="aid" value="${result.id}" />   
        &nbsp;&nbsp;&nbsp;<input type="submit" value="提交"  class="btn btn-info"/>
						</c:if><c:if test="${result.status ==2}">待销假
						</c:if>
						<c:if test="${result.status ==3}">不批准
						</c:if><c:if test="${result.status ==4}">等待销假
						</c:if><c:if test="${result.status ==5}">已销假
						</c:if>
						</td>
				</tr>
			</form>
		</c:forEach>
	</table>
</div>
<%@ include file="footer.jsp"%>