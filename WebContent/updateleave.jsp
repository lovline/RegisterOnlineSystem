<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>
<b>考勤管理</b>
<script language="javascript">
function selectIt(action,ckName){ 
    var testform=document.getElementsByName(ckName); 
    for(var i=0 ;i<testform.length;i++){ 
        if(testform[i].type=="checkbox"){ 
            e=testform[i]; 
            e.checked=(action=="selectAll")?1:(action=="clear"?0:(!e.checked)); 
        } 
    }     
}
/*
function selectIt(action){ 
    var testform=document.getElementById("bdkey"); 
    for(var i=0 ;i<testform.elements.length;i++){ 
        if(testform.elements[i].type=="checkbox"){ 
            e=testform.elements[i]; 
            e.checked=(action=="selectAll")?1:(!e.checked); 
        } 
    }     
} 
</script>
<br />
<br />
<br />
<table class="table">
	<tr align="right">
		<td colspan="4"></td>
		<td><a class="btn btn-primary btn-xs"
			href="${pageContext.request.contextPath}/leave/"><b>返回</b></a></td>
	</tr>
</table>
<table class="table table-bordered">
	<form action="formName" method="post">
		<tr class="info" align="center">
			<th scope="col" width="100"><input type="checkbox" name="alls"
				onClick="selectAll('formName','no')" title="全选/取消全选"></th>
			<th scope="col">编号</th>
			<th scope="col">员工</th>
			<th scope="col">时间</th>
			<th scope="col">签到</th>
		</tr>
		<c:forEach items="${custList}" var="ch" varStatus="list">
			<tr class="active" align="center">
				<td><input type="checkbox" name="no" value="ch.id"
					title="选择/不选择"></td>
				<td>${list.index+1}</td>
				<td>${ch.name}</td>
				<td>${ch.checkin_time}</td>
				<td><c:if test="${ch.type == 1}">下班			
				</c:if> <c:if test="${ch.type == 2}">上班			
				</c:if></td>
			</tr>

		</c:forEach>
		<tr align="center">
			<td colspan="4"><input type="button" name="actionButton"
				value="操作" onclick="do_action()" /></td>
		</tr>
	</form>

	<!-- <form action="" method="post">
	<tr class="active" align="center" >
		<td><input type="checkbox" onclick="box(this)" />&nbsp;&nbsp;/&nbsp;全选</td>
		<td colspan="4"><input type="submit" name="delet" value="删除"></td>
	</tr>
	</form> -->
</table>


<%@ include file="footer.jsp"%>