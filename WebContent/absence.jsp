<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<div class="row">
	<h1 align="center">请假管理</h1>
</div>
</br>
<div>
	<table align="center" class="table table-bordered">
		<tr class="bg-primary">
			<th>姓名</th>
			<th>申请时间</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>请假操作</th>
		</tr>
		<c:forEach items="${results}" var="result">
			<form method="post" action="">
				<tr class="bg-success">
					<td>${result.name}</td>
					<td>${result.created_at}</td>
					<td>${result.start_time}</td>
					<td>${result.end_time}</td>
					<td><c:if test="${result.status == 1}">
							<select name="z">
								<option value="">选择</option>
								<option value="2">批准</option>
								<option value="3">拒绝</option>
							</select>
							<input type="hidden" name="aid" value="${result.id}" />   
        &nbsp;&nbsp;&nbsp;<input type="submit" value="提交"  class="btn btn-info"/>
						</c:if>
						<c:if test="${result.status ==2">
							<input type="hidden" name="aid" value="${result.id}" />   
      	<input type="submit" value="销假"  class="btn btn-info"/>
						</c:if>
						</td>
				</tr>
			</form>
		</c:forEach>
	</table>
</div>
<%@ include file="footer.jsp"%>