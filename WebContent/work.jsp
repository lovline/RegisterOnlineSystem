<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<div class="row">
	<h1>查看工作</h1>
</div>
<script type="text/javascript">
	function setTimes() {
		var date = new Date();
		var curTime = date.toLocaleString();
		var divObj = document.getElementById("time");
		divObj.innerHTML = curTime;
	}

	var timer = setInterval("setTimes()");
</script>

<center>
	<form action=" " method="post">
		<table width="600" border="1">
			<tr style="line-height: 2">
				<b>
					<td>时间</td>
					<td id="time"></td>
				</b>
			</tr>
			<tr style="line-height: 2">
				<b>
					<td>工作</td>
					<td><input type="text" name="tet" /></td>
				</b>
			</tr>
			<tr style="line-height: 2">
				<b>
					<td>用户</td>
					<td>

							<c:forEach items="${uBean}" var="ch" varStatus="list">
								${ch.realname}
							</c:forEach>
					</td>
				</b>
			</tr>
			<tr style="line-height: 2">
				<b>
					<td>操作</td>

					<td><input type="submit" value="添加" width="300" /></td>
				</b>
			</tr>

		</table>
	</form>
	<br /> <br /> <br />
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
			<form action="" method="post">
				<tr>
					<td height="30">${ list.count }</td>
					<td width="150">${ch.deadline}</td>
					<td>${ch.detail}</td>
					<td width="150">
					<c:if test="${ch.status==0}">
							<select name="custId">
								<option>选择客户</option>
								<option value="">${ch.name}</option>
							</select>
						<input type="hidden" name="worknum" value="${ch.id}" />
						<input type="submit" value="分配" />
					</c:if> 
					<c:if test="${ch.status==1}">已经接受</c:if> 
					<c:if test="${ch.status==2}">拒绝</c:if> 
					<c:if test="${ch.status==3}">
							<input type="submit" value="关闭 " />
					</c:if></td>
				</tr>
			</form>
		</c:forEach>
	</table>
</center>
<%@ include file="../footer.jsp"%>