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
import="javax.servlet.http.HttpSession"
%>

<%	
	
	String id = (String)session.getAttribute("USERID");
	String name = (String)session.getAttribute("USERNAME");
	if(id!="" && name !=""){
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>トップページ</title>

<header><center><h1 class="h">トップページ</h1></center>

<p>ようこそ <%=name%> さん </p>

	<%
	}
	%>
</header>
  

<p>現在時刻<span id = "timer"> </span></p>  

    
    
<a href="Search.jsp" class="btn-circle-2d-emboss"></a>

<a href="#" class="btn-circle-3d-emboss"></a>
    
<a href="#" class="btn-circle-4d-emboss"></a>
    
<a href="#" class="btn-circle-5d-emboss"></a>


<link rel="stylesheet"  href="Style/index.css">    
<script src="Script/index.js" >
</script>    

</head>
<body>

</body>
</html>