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


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<link rel="stylesheet"  href="Style/Common.css">  
<%
    String AA01DOCID_param =  request.getParameter("AA01DOCID");
 	BigDecimal AA01DOCID = new BigDecimal(AA01DOCID_param);
	int MODE =  Integer.parseInt(request.getParameter("MODE"));
	
%>
<%	//検索メソッド呼び出し
 	AA01Beans_02 ab2 = new AA01Beans_02();
	ab2 = ab2.Search02(AA01DOCID,MODE);
%>	
<%	//編集画面のデータを表示する
	
	if(ab2 != null && request != null){	
	Common con = new Common();
	String AA01SAKUSEMD = ab2.getAA01SAKUSEMD().toString();
	String message1 = (String)request.getAttribute("message1");
	
	//セッション	
	String id = (String)session.getAttribute("USERID");
	String name = (String)session.getAttribute("USERNAME");
	if(id!="" && name !=""){

%> 

<header>	
<div class="header_logo">アプリケーション_初号機 -登録画面-</div>
<div class="namea">
<p>ようこそ <%=name%> さん</p>

	<%
	}
	%>
</div>
</header>

<%
	if(message1 != null){
%>
	<p>保存しました。</p>	
<%
	}
%>
<button class="buttonBack" onclick="location.href='Search.jsp'">戻る</button>

<% if(request.getContextPath().equals("/YMCA")){ %>
		<form action="/YMCA/SaveServlet" method="post">
	<%
	}else{%>
		<form action="/SaveServlet" method="post">
	<%
	}
	%>

<input type="submit" class="button" value="保存">　 

<br> 
<br>
<!-- MODE -->	 <input type="hidden" name="MODE" value = <%=MODE%>> 
<!-- 文書ID -->	 <input type="hidden" name="AA01DOCID" value = <%=ab2.getAA01DOCID()%>> 
	
作成日:<input type="date" name="AA01SAKUSEMD" value = <%=con.fmtSlash(AA01SAKUSEMD)%>>
	
<p>カテゴリ1:

<input type="radio" name="AA01CATE1" value="1" <%if(ab2.getAA01CATE1().equals("1")){ %> checked="checked"<%} %> >WebPerformer
<input type="radio" name="AA01CATE1" value="2" <%if(ab2.getAA01CATE1().equals("2")){ %> checked="checked"<%} %>>Java
<input type="radio" name="AA01CATE1" value="3" <%if(ab2.getAA01CATE1().equals("3")){ %> checked="checked"<%} %>>Javascript
<input type="radio" name="AA01CATE1" value="4" <%if(ab2.getAA01CATE1().equals("4")){ %> checked="checked"<%} %>>SQL
<input type="radio" name="AA01CATE1" value="5" <%if(ab2.getAA01CATE1().equals("5")){ %> checked="checked"<%} %>>HTML/CSS
<input type="radio" name="AA01CATE1" value="6" <%if(ab2.getAA01CATE1().equals("6")){ %> checked="checked"<%} %>>IT関連
<input type="radio" name="AA01CATE1" value="7" <%if(ab2.getAA01CATE1().equals("7")){ %> checked="checked"<%} %>>仕事に関すること
<input type="radio" name="AA01CATE1" value="8" <%if(ab2.getAA01CATE1().equals("8")){ %> checked="checked"<%} %>>その他
</p>

<p>カテゴリ2:

<input type="radio" name="AA01CATE2" value= "1" <%if(ab2.getAA01CATE2().equals("1")){ %> checked="checked"<%} %>>忘備録
<input type="radio" name="AA01CATE2" value="2"  <%if(ab2.getAA01CATE2().equals("2")){ %> checked="checked"<%} %>>エラー/課題解決
<input type="radio" name="AA01CATE2" value="3" <%if(ab2.getAA01CATE2().equals("3")){ %> checked="checked"<%} %>>これ便利/ノウハウ
<input type="radio" name="AA01CATE2" value="4" <%if(ab2.getAA01CATE2().equals("4")){ %> checked="checked"<%} %>>質問
<input type="radio" name="AA01CATE2" value="5" <%if(ab2.getAA01CATE2().equals("5")){ %> checked="checked"<%} %>>つぶやき
</p>
概要: <input type="text" class="AA01GAIYOU" name="AA01GAIYOU"  size="80" value = "<%=ab2.getAA01GAIYOU()%>"><br>
<br>

詳細<br>
<textarea name="AA01SYOUSAI" class="AA01SYOUSAI" rows="8" cols="80" style="margin: 0px; width: 708px; height: 236px;"><%=ab2.getAA01SYOUSAI()%></textarea><br>


<!-- ユーザー --><br>
<input type="hidden" name="AA01USERID" value = <%=ab2.getAA01USERID()%>> 


	<% 
	  }
	%>

</form>

	<div class="wrapper">
    </div>
	<!-- footer -->
  <footer>
<p>© All rights reserved by K.</p>
  </footer>	

</body>
</html>