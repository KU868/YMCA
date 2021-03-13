<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page 
import="java.math.BigDecimal"
import="java.sql.*"
import="java.util.*"
import="java.util.List"
import="java.util.ArrayList"
import="beans.AA01Beans_02" 
import="common.Common" 

%>

<%
	String message = (String)request.getAttribute("message");
	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<header>
<%
	if(message != null){
%>
	<p><%=message %></p>	
<%
	}
%>
   
</header>

<form action="LoginServlet"  method="POST">

<table>
	<tr><td>ID：</td>
	<td><input type="text" name="ID"></td></tr>
</table>

<ul class="line">
	<input type="submit" class="button" value="ログイン">
</ul>

</form>

</body>
</html>