<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="header.jsp" %>
<%@ include file="nav.jsp" %>
<div class="row">
<h1 align="center">请假管理</h1>
</div>
</br>
    <div>        
    <table align="center" class="table table-bordered">  
        <tr>
            <th>姓名</th> 
            <th>申请时间</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>申请批准</th>
            <th>提交申请</th>
        </tr>
        <c:forEach items="${results}" var="result"> 
        <form method="post" action=""> 
        <input type="hidden" name="aid" value="${result.id}"/>          
        <tr>
            <td>${result.name}</td>                                	
            <td>${result.created_at}</td>
            <td>${result.start_time}</td>
            <td>${result.end_time}</td>                
            <c:if test="${result.status == 0}"><td>
            <select name = "z">
            <option value="1">批准</option>
            <option value="2">拒绝 </option>
            </select></td> <td><input type="submit" value="提交" /></td></c:if>  
            <c:if test="${result.status == 1}"><td>已批准</td> <td>NULL</td></c:if>
            <c:if test="${result.status == 2}"><td>已拒绝</td> <td>NULL</td></c:if>                   
        </tr> 
        </form>        
        </c:forEach>
    </table>               
    </div> 
<%@ include file="footer.jsp" %>