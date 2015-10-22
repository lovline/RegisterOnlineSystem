<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>连接到MySQL数据库练习</title>
</head>
<%
    //加载驱动
    Class.forName("com.mysql.jdbc.Driver");
    //创建一个连接对象
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","lovline");
    //创建Statement
    Statement stmt = conn.createStatement();
    //执行查询
    ResultSet rs = stmt.executeQuery("select * from stu");
%>
<table bgcolor="#9999dd" border="1" width="300">
<%
    //遍历结果集
    while(rs.next())
    {
%>
<tr>
    <td><%=rs.getString(1)%></td>
    <td><%=rs.getString(2)%></td>
    <td><%=rs.getString(3)%></td>
</tr>
<%}%>
</table>
</body>
</html>