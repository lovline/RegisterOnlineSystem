<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../nav.jsp"%>
<script type="text/javascript">
	function setTimes() {
		var date = new Date();
		var curTime = date.toLocaleString();
		var divObj = document.getElementById("time");
		divObj.innerHTML = curTime;
	}

	var timer = setInterval("setTimes()");
</script>
<b>新增工作</b>
<div style="width: 600; float: right">
	<br /> <br /> <br /> <a class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/worktwo/"><b>查看分配</b></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
		class="btn btn-primary btn-xs"
		href="${pageContext.request.contextPath}/workthree/"><b>处理中任务</b></a>
</div>

<br>
<br>
	<table width="600" class="table table-bordered">
		<form action=" " method="post">
		<tr style="line-height: 2" align="center">
			<b>
				<td class="warning">时间</td>
				<td id="time" class="active"></td>
			</b>
		</tr>
		<tr style="line-height: 2" align="center">
			<b>
				<td class="info">工作</td>
				<td class="danger"><textarea class="form-control"
						placeholder="请输入。。。" style="resize: none" rows="5" cols="60"
						name="tet" onclick="this.value='';"></textarea></td>

			</b>
		</tr>

		<tr style="line-height: 2" align="center">
			<b>
				<td class="success">操作</td>
				<td class="active"><input type="submit" value="添加" width="300"
					class="btn btn-warning" /></td>
			</b>
		</tr>
		</form>
	</table>
<%@ include file="../footer.jsp"%>