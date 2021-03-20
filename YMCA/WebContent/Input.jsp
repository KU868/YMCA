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


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
<h1>登録画面</h1>

<%
    String AA01DOCID_param =  request.getParameter("AA01DOCID");
 	BigDecimal AA01DOCID = new BigDecimal(AA01DOCID_param);
	int MODE =  Integer.parseInt(request.getParameter("MODE"));
	
%>
<%	//検索メソッド呼び出し
 	AA01Beans_02 ab2 = new AA01Beans_02();
	AA01Beans_02 a2 = ab2.Search02(AA01DOCID,MODE);
%>	
<%	//編集画面のデータを表示する
	
	System.out.println("JSP確認");
	if(a2 != null){	
	Common con = new Common();
	String AA01SAKUSEMD = a2.getAA01SAKUSEMD().toString();	
%> 
	
	<form action="/SaveServlet" method="post">
<!-- MODE -->	 <input type="hidden" name="MODE" value = <%=MODE%>> 
<!-- 文書ID -->	 <input type="hidden" name="AA01DOCID" value = <%=a2.getAA01DOCID()%>> 
	
作成日<input type="date" name="AA01SAKUSEMD" value = <%=con.fmtSlash(AA01SAKUSEMD)%>>
	
<p>カテゴリ1

<input type="radio" name="AA01CATE1" value="1" <%if(a2.getAA01CATE1().equals("1")){ %> checked="checked"<%} %> >WebPerformer
<input type="radio" name="AA01CATE1" value="2" <%if(a2.getAA01CATE1().equals("2")){ %> checked="checked"<%} %>>java
<input type="radio" name="AA01CATE1" value="3" <%if(a2.getAA01CATE1().equals("3")){ %> checked="checked"<%} %>>javascript
<input type="radio" name="AA01CATE1" value="4" <%if(a2.getAA01CATE1().equals("4")){ %> checked="checked"<%} %>>SQL
<input type="radio" name="AA01CATE1" value="5" <%if(a2.getAA01CATE1().equals("5")){ %> checked="checked"<%} %>>HTML/CSS
<input type="radio" name="AA01CATE1" value="6" <%if(a2.getAA01CATE1().equals("6")){ %> checked="checked"<%} %>>IT関連
<input type="radio" name="AA01CATE1" value="7" <%if(a2.getAA01CATE1().equals("7")){ %> checked="checked"<%} %>>日々の業務
<input type="radio" name="AA01CATE1" value="8" <%if(a2.getAA01CATE1().equals("8")){ %> checked="checked"<%} %>>その他
</p>

<p>カテゴリ2

<input type="radio" name="AA01CATE2" value= "1" <%if(a2.getAA01CATE2().equals("1")){ %> checked="checked"<%} %>>忘備録
<input type="radio" name="AA01CATE2" value="2"  <%if(a2.getAA01CATE2().equals("2")){ %> checked="checked"<%} %>>エラー/課題解決
<input type="radio" name="AA01CATE2" value="3" <%if(a2.getAA01CATE2().equals("3")){ %> checked="checked"<%} %>>これ便利ですよ
<input type="radio" name="AA01CATE2" value="4" <%if(a2.getAA01CATE2().equals("4")){ %> checked="checked"<%} %>>質問
<input type="radio" name="AA01CATE2" value="5" <%if(a2.getAA01CATE2().equals("5")){ %> checked="checked"<%} %>>つぶやき
</p>

概要<input type="text" name="AA01GAIYOU" value = <%=a2.getAA01GAIYOU()%>><br>
<br>

詳細：<br>
<textarea name="AA01SYOUSAI" rows="8" cols="80" ><%=a2.getAA01SYOUSAI()%></textarea><br>


<!-- ユーザー --><br>
<input type="hidden" name="AA01USERID" value = <%=a2.getAA01USERID()%>> 

ファイル

	<% 
	  }else{
	%>
		<div align="center">検索結果はありません。</div>
	
	<%
	  }
	%>




<input type="submit" value="保存">
</form>

</body>
</html>