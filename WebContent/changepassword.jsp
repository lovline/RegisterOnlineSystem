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
	</script>
	<h1>密码修改</h1>
	<form action=" " name="form1" method="post"
		onsubmit="return CheckForm();">
		初始密码:<input type="password" name="pwd" /><br />
		</p>
		密 &nbsp; &nbsp; 码 :<input type="password" id="pwd1" name="pwd1" /><br />
		</p>
		确认密码:<input type="password" name="pwd2" id="pwd2" /><br />
		</p>
		<input type="submit" class="btn btn-primary btn-lg" value="确认" /> <input
			type="reset" class="btn btn-primary btn-lg" value="重置" /><br>

	</form>
	</div>
</body>




<%@ include file="footer.jsp"%>