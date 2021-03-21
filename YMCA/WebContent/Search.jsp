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
import= "java.net.InetAddress"
%>

	<!-- 検索結果 の取得-->
	<%
	System.out.println(InetAddress.getLocalHost().getHostName());
	System.out.println(InetAddress.getLocalHost());
	
	
	%>
	
	
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


	<!-- "location.href='/Input.jsp?   スラッシュをつけると、/YMCA/が消える-->
	<button type=“button_NEW” onclick="location.href='Input.jsp?AA01DOCID=0&MODE=0'">新規登録</button>	

	<form action="/SearchServlet" method="post">


<p>カテゴリ1
<input type="checkbox" name="AA01CATE1" value="1" >WebPerformer
<input type="checkbox" name="AA01CATE1" value="2">Java
<input type="checkbox" name="AA01CATE1" value="3">Javascript
<input type="checkbox" name="AA01CATE1" value="4">SQL
<input type="checkbox" name="AA01CATE1" value="5">HTML/CSS
<input type="checkbox" name="AA01CATE1" value="6">IT関連
<input type="checkbox" name="AA01CATE1" value="7">仕事に関すること
<input type="checkbox" name="AA01CATE1" value="8">その他
</p>

 		
<p>カテゴリ2
<input type="checkbox" name="AA01CATE2" value="1">忘備録
<input type="checkbox" name="AA01CATE2" value="2">エラー/課題解決
<input type="checkbox" name="AA01CATE2" value="3">これ便利/ノウハウ
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
                    <a href= "http://kkaa01.herokuapp.com/Input.jsp?AA01DOCID=<%= ab.getAA01DOCID()%>&MODE=1"> <p><%= ab.getAA01SAKUSEMD() %></p></a>
                </td>
                <td>
                    <%
                        if(ab.getAA01CATE1() == "1"){
                			%>WebPerformer<%
                        }else if(ab.getAA01CATE1() == "2"){
                            %>Java<%
                        }else if(ab.getAA01CATE1() == "3"){
                            %>Javascript<%
                        }else if(ab.getAA01CATE1() == "4"){
                            %>SQL<%
                        }else if(ab.getAA01CATE1() == "5"){
                            %>HTML/CSS<%
                        }else if(ab.getAA01CATE1() == "6"){
                            %>IT関連<%
                        }else if(ab.getAA01CATE1() == "7"){
                            %>仕事に関すること<%
                        }else if(ab.getAA01CATE1() == "8"){
                            %>その他<%
                        }else{
                            %> <%
                        }
                         %>
                </td> 
                <td>
                    <%= ab.getAA01CATE2()%>
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
                

    </tr>
    <%
		 }
	  }
	%>

	</table>
		
	
		
	


</body>
</html>