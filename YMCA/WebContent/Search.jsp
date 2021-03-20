<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page 
import="java.math.BigDecimal"
import="java.sql.*"
import="java.util.*"
import="java.util.List"
import="java.util.ArrayList"
import="beans.AA01Beans_01" 
import="common.Common" 
%>

	<!-- 検索結果 の取得-->
	
<%
		List<AA01Beans_01> aa01 = (List<AA01Beans_01>)request.getAttribute("aa01"); //JSPに帰ってきていない 　JSP自画面遷移で検索
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>


	<button type=“button_NEW” onclick="location.href='http://localhost:8080/YMCA/Input.jsp?AA01DOCID=0&MODE=0'">新規登録</button>
		

	<form action="/SearchServlet" method="post">


<p>カテゴリ1
<input type="checkbox" name="AA01CATE1" value="1" >WebPerformer
<input type="checkbox" name="AA01CATE1" value="2">java
<input type="checkbox" name="AA01CATE1" value="3">javascript
<input type="checkbox" name="AA01CATE1" value="4">SQL
<input type="checkbox" name="AA01CATE1" value="5">HTML/CSS
<input type="checkbox" name="AA01CATE1" value="6">IT関連
<input type="checkbox" name="AA01CATE1" value="7">業務の取り組み方
<input type="checkbox" name="AA01CATE1" value="8">その他
</p>

 		
<p>カテゴリ2
<input type="checkbox" name="AA01CATE2" value="1" >忘備録
<input type="checkbox" name="AA01CATE2" value="2">エラー/課題解決
<input type="checkbox" name="AA01CATE2" value="3">これ便利ですよ
<input type="checkbox" name="AA01CATE2" value="4">質問
<input type="checkbox" name="AA01CATE2" value="5">つぶやき
</p>
 		
概要<input type="text" name="AA01GAIYOU"><br><br>
 
ユーザー<input type="text" name="ZZ01USERNAME" ><br><br>
 


		<input type="submit" value="検索">
	</form>


	<!-- 一覧ラベル -->	
	<table border="1" width="60%" class="list">
            <tr>
                <th>
                    作成日
                </th>
                <th>
                    カテゴリ1
                </th>
                <th>
                    カテゴリ2
                </th>
                <th>
                    概要
                </th>
                <th>
                    ユーザー
                </th>
            </tr>
            
	
		
	<%
            					//コレクションはループ内で取得する(一覧)
       if(aa01 != null && aa01.size() != 0 ){
         for(AA01Beans_01 ab : aa01) {
            				%> 
	
	<tr>
				
                <td><!-- パラメタとの幅は空けない。仮に前が少し空いていた場合 空白文字がString[0] にはいってしまい、受取先で"　1"　として受け取ってしまう 　→ formatエラーになっていた -->
                    <a href= "http://localhost:8080/YMCA/Input.jsp?AA01DOCID=<%= ab.getAA01DOCID()%>&MODE=1"> <p><%= ab.getAA01SAKUSEMD() %></p></a>
                </td>
                <td>
                    <%= ab.getAA01CATE1() %>
                </td>
                <td>
                    <%= ab.getAA01CATE2() %>
                </td>
                
                <td>
                    <%= ab.getAA01GAIYOU() %>
                </td>
                <td>
                    <%= ab.getZZ01USERNAME()%>
                </td>
                <td>
                <!-- doget,動きます -->
                <a href="SaveServlet?AA01DOCID=<%= ab.getAA01DOCID()%>&MODE=2">削除</a>
                </td>  
                
       
                
                <%--<td>
                <button type=“button_EDIT” onclick="location.href='http://localhost:8080/YMCA/Input.jsp?AA01DOCID=' + <%= ab.getAA01DOCID()%> +  '&MODE=1'">編集</button>
                </td> --%>
                
                
                <%-- <td><%
                        if(item.getFinishedDate() != null) {
                   	        %><%= item.getFinishedDate() %><%
                        }else{
                            %>未<%
                        }
                %></td> --%>
    </tr>
    <%
		 }
	  }else{
	%>

	</table>
		
	<div align="center">検索結果はありません。</div>
	<% 	  
	  }
	%>	
		
	


</body>
</html>