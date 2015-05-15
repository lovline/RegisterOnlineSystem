<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<<<<<<< HEAD
<div style="width: 600">
	<b>新增工作</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/worktwo/"><b>查看分配</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/workthree/"><b>完成任务</b></a>
=======
<div class="row">
	<h1>查看工作</h1>
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
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
<<<<<<< HEAD

	<form action=" " method="post">
		<table width="600" class="table table-bordered">
			<tr style="line-height: 2">
				<b>
					<td class="warning">时间</td>
					<td id="time" class="active"></td>
=======
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
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
				</b>
			</tr>
			<tr style="line-height: 2">
				<b>
<<<<<<< HEAD
					<td class="info">工作</td>
					<td class="danger"><textarea style="resize: none" rows="5" cols="60" name="tet" onclick="this.value='';">请输入。。。</textarea></td>
				</b>
			</tr>

			<tr style="line-height: 2">
				<b>
					<td class="success">操作</td>
					<td class="active"><input type="submit" value="添加" width="300"
						class="btn btn-warning" /></td>
=======
					<td>工作</td>
					<td><input type="text" name="tet" /></td>
				</b>
			</tr>
			
			<tr style="line-height: 2">
				<b>
					<td>操作</td>

					<td><input type="submit" value="添加" width="300" /></td>
>>>>>>> 18fa01b6b62788e793f99385473f2dae5c2cf572
				</b>
			</tr>

		</table>
	</form>

</center>
<%@ include file="../footer.jsp"%>