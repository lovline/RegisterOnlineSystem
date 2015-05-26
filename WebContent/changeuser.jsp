<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>

<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		var email = $("#email").val();
		var name = $("#name").val();
		var servletemail= "${ userBean.email }";
		var servletname= "${ userBean.realname }";
		if (email.trim() == ""){
			alert("Email不能为空");
			$("#email").focus();
			return false;
		}
		else if(name.trim() == ""){
			alert("姓名不能为空");
			$("#name").focus();
			return false;
		}
		else if((email.trim() == servletemail)&&(name.trim() == servletname)){
			alert("邮箱和用户名与原来一样，无需更改！");
			$("#email").focus();
			return false;
		}
		return true;
	});
});

</script>


<h1>修改用户信息</h1>


<div class='col-md-8'>
<form class="form-horizontal" method="post">
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">修改邮箱</label>
    <div class="col-sm-10">
      <input type="email" class="form-control" id="email" name="email" placeholder="Email" value=${ userBean.email }>
    </div>
  </div>
  <div class="form-group">
    <label for="text" class="col-sm-2 control-label">修改用户名</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="name" name="name" placeholder="Name" value=${ userBean.realname }>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" id="submit" class="btn btn-primary btn-lg">确定</button>
    </div>
  </div>
</form>
</div>
<%@ include file="footer.jsp" %>