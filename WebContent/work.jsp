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
	<br /> <br /> <br />
	<table width="600">
		<tr>
			<td><a href="${pageContext.request.contextPath}/worktwo/"><b>查看分配</b></a>____<a href="${pageContext.request.contextPath}/workthree/"><b>已接任务</b></a></td>
		</tr>
	</table>
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
					<td>操作</td>

					<td><input type="submit" value="添加" width="300" /></td>
				</b>
			</tr>

		</table>
	</form>

</center>
<%@ include file="../footer.jsp"%>