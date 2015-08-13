<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>



<!--meta http-equiv="Content-Type" content="text/html; charset=gb2312" /-->
<body>
	<script language="javascript">
		function CheckForm() {

			var pwd1 = $("#pwd1").val();
			var pwd2 = $("#pwd2").val();
			if (pwd1 != pwd2) {
				alert("您两次输入的密码不一样！请重新输入.");
				return false;
			}
		}
	</script>

	<h2>密码修改</h2>
	<div class='col-md-8'>
	<form class="form-horizontal" action=" " name="form1" method="post"
		onsubmit="return CheckForm();" style="margin-top: 20px">

		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pwd" name="pwd"
					placeholder="password">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">新密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pwd1" name="pwd1"
					placeholder="password">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="pwd2" name="pwd2"
					placeholder="password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">confirm</button>
				<button type="reset" class="btn btn-default">reset</button>
			</div>
		</div>

	</form>
	</div>
</body>




<%@ include file="footer.jsp"%>