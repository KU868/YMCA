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
import="javax.servlet.http.HttpSession"

%>

	<!-- 検索結果 の取得-->	
<%
		

			// 1. JSPのフォームからおくられてきたもの　検索用　リクエストパラメータを取得
		String[] AA01CATE1 = (String[])request.getAttribute("AA01CATE1");
		System.out.println(AA01CATE1);	
		String[] AA01CATE2 = (String[])request.getAttribute("AA01CATE2");
			
		String AA01GAIYOU = (String)request.getAttribute("AA01GAIYOU");
		String ZZ01USERNAME = (String)request.getAttribute("ZZ01USERNAME");



			
		List<AA01Beans_01> aa01 = (List<AA01Beans_01>)request.getAttribute("aa01");
		String message2 = (String)request.getAttribute("message2");
		String KEKKA = (String)request.getAttribute("KEKKA");
	
		//セッション
		String id = (String)session.getAttribute("USERID");
		String name = (String)session.getAttribute("USERNAME");
		if(id!="" && name !=""){
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
	<link rel="stylesheet"  href="Style/Common.css">  
	<link rel="stylesheet"  href="Style/Search.css">  
<header>

<div class="header_logo">アプリケーション_初号機 -検索画面-</div>
<div class="namea">
<p>ようこそ <%=name%> さん</p>

	<%
	}
	%>
</div>
</header>
<%
	if(message2 != null){
%>
	<p>削除しました。</p>	
<%		
	}
%>
	<!-- "location.href='/Input.jsp?   スラッシュをつけると、/YMCA/が消える-->
	<button class="button" onclick="location.href='Input.jsp?AA01DOCID=0&MODE=0'">新規登録</button>	
	
	<%//オブジェクト
    InetAddress ia = InetAddress.getLocalHost();
    String ip = ia.getHostAddress();       //IPアドレス
    String hostname = ia.getHostName();    //ホスト名
    System.out.println("IPアドレス：" + ip);
    System.out.println("ホスト名：" + hostname);%>
	
	<% if(request.getContextPath().equals("/YMCA")){ %>
		<form action="/YMCA/SearchServlet" method="post">
	<%
	}else{%>
		<form action="/SearchServlet" method="post">
	<%
	}
	%>
	
	

<p>カテゴリ1:
<input type="checkbox" name="AA01CATE1" value="1" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("1")){%> checked <%}%><%}%><%}%>>WebPerformer
<input type="checkbox" name="AA01CATE1" value="2" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("2")){%> checked <%}%><%}%><%}%>>Java
<input type="checkbox" name="AA01CATE1" value="3" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("3")){%> checked <%}%><%}%><%}%>>Javascript
<input type="checkbox" name="AA01CATE1" value="4" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("4")){%> checked <%}%><%}%><%}%>>SQL
<input type="checkbox" name="AA01CATE1" value="5" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("5")){%> checked <%}%><%}%><%}%>>HTML/CSS
<input type="checkbox" name="AA01CATE1" value="6" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("6")){%> checked <%}%><%}%><%}%>>IT関連
<input type="checkbox" name="AA01CATE1" value="7" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("7")){%> checked <%}%><%}%><%}%>>仕事に関すること
<input type="checkbox" name="AA01CATE1" value="8" <%if(AA01CATE1 != null){ %><%for(int i = 0; i < AA01CATE1.length;i++  ){ %> <%if(AA01CATE1[i].equals("8")){%> checked <%}%><%}%><%}%>>その他

</p>

		
<p>カテゴリ2:
<input type="checkbox" name="AA01CATE2" value="1" <%if(AA01CATE2 != null){ %><%for(int i = 0; i < AA01CATE2.length;i++  ){ %> <%if(AA01CATE2[i].equals("1")){%> checked <%}%><%}%><%}%>>忘備録
<input type="checkbox" name="AA01CATE2" value="2" <%if(AA01CATE2 != null){ %><%for(int i = 0; i < AA01CATE2.length;i++  ){ %> <%if(AA01CATE2[i].equals("2")){%> checked <%}%><%}%><%}%>>エラー/課題解決
<input type="checkbox" name="AA01CATE2" value="3" <%if(AA01CATE2 != null){ %><%for(int i = 0; i < AA01CATE2.length;i++  ){ %> <%if(AA01CATE2[i].equals("3")){%> checked <%}%><%}%><%}%>>これ便利/ノウハウ
<input type="checkbox" name="AA01CATE2" value="4" <%if(AA01CATE2 != null){ %><%for(int i = 0; i < AA01CATE2.length;i++  ){ %> <%if(AA01CATE2[i].equals("4")){%> checked <%}%><%}%><%}%>>質問
<input type="checkbox" name="AA01CATE2" value="5" <%if(AA01CATE2 != null){ %><%for(int i = 0; i < AA01CATE2.length;i++  ){ %> <%if(AA01CATE2[i].equals("5")){%> checked <%}%><%}%><%}%>>つぶやき
</p>

概要:　<input type="text" class="AA01GAIYOU" size="50" placeholder="キーワード" name="AA01GAIYOU"<%if(AA01GAIYOU != null){%> value=<%=AA01GAIYOU%> <%}%>><br><br>


ユーザー:　<input type="text" class="ZZ01USERNAME" placeholder="Name" name="ZZ01USERNAME"  <%if(ZZ01USERNAME != null){%> value=<%=ZZ01USERNAME%> <%}%>><br><br>
 


	
		<input type="submit" class="button" value="検索">
	</form>
	
	<%
	if(KEKKA!=null){
		if(KEKKA.equals("0")){
		%>検索結果はありません<%
		}
	}	
	%>     
	

	<!-- 一覧ラベル -->	
	<table border="1"  class="list"> 	
            <tr>
                <th>
                    <div class="list" id="AA01SAKUSEMD_label" >作成日</div>
                </th>
                <th>
                    <div class="list" id="AA01CATE1_label" width = "60px">カテゴリ1</div>
                </th>
                <th>
                     <div class="list" id="AA01CATE2_label">カテゴリ2</div>
                </th>
                <th>
                    <div class="list" id="AA01GAIYOU_label">概要</div>
                </th>
                <th>
                    <div class="list" id="ZZ01USERNAME_label">ユーザ</div>
                </th>
            </tr>  
		
	<%
       //コレクションはループ内で取得する(一覧)
       if(aa01 != null && aa01.size() != 0){
    	   Common con = new Common();
    	  	
         for(AA01Beans_01 ab : aa01) {
        	 //String AA01SAKUSEMD = ab.getAA01SAKUSEMD().toString();
	%>
	
	<tr>	
                <td><!-- パラメタとの幅は空けない。仮に前が少し空いていた場合 空白文字がString[0] にはいってしまい、受取先で"　1"　として受け取ってしまう 　→ formatエラーになっていた -->
                	<div class="list" id="AA01SAKUSEMD">
                	<%
                	if(!(ab.getAA01SAKUSEMD().toString().equals("0"))){ 
                	%>
                    <a href= "Input.jsp?AA01DOCID=<%= ab.getAA01DOCID()%>&MODE=1"><p><%= con.fmtSlash(ab.getAA01SAKUSEMD().toString())%></p></a>              		
               		<%
                	}else{
                	%> 
                	<a href= "Input.jsp?AA01DOCID=<%= ab.getAA01DOCID()%>&MODE=1"><p>入力無し</p></a>
                	<%
                    }
                    %>
                	
               		</div>
                </td>
                
                <td>
                    <div class="list" id="AA01CATE1" width = "60px">       		
                    <%
                        if(ab.getAA01CATE1().equals("1")){
                			%>WebPerformer<%
                        }else if(ab.getAA01CATE1().equals("2")){
                            %>Java<%
                        }else if(ab.getAA01CATE1().equals("3")){
                            %>Javascript<%
                        }else if(ab.getAA01CATE1().equals("4")){
                            %>SQL<%
                        }else if(ab.getAA01CATE1().equals("5")){
                            %>HTML/CSS<%
                        }else if(ab.getAA01CATE1().equals("6")){
                            %>IT関連<%
                        }else if(ab.getAA01CATE1().equals("7")){
                            %>仕事に関すること<%
                        }else if(ab.getAA01CATE1().equals("8")){
                            %>その他<%
                        }else{
                            %> <%
                        }
                         %>
                         </div>     
                </td> 
                <td>
                	<div class="list" id="AA01CATE2">
                	<%
                        if(ab.getAA01CATE2().equals("1")){
                			%>忘備録<%
                        }else if(ab.getAA01CATE2().equals("2")){
                            %>エラー/課題解決<%
                        }else if(ab.getAA01CATE2().equals("3")){
                            %>これ便利/ノウハウ<%
                        }else if(ab.getAA01CATE2().equals("4")){
                            %>質問<%
                        }else if(ab.getAA01CATE2().equals("5")){
                            %>つぶやき<%
                        }else{
                            %> <%
                        }
                         %>
                     </div>    

                </td>
                
                <td>
                <div class="list" id="AA01GAIYOU">
                    <%= ab.getAA01GAIYOU() %>
                </div>    
                </td>
                <td>
                    <%= ab.getZZ01USERNAME()%>
                </td>
                <td>
				 <div class="list" id="ZZ01USERNAME">      
                <!-- doget,動きます -->
                <a href="SaveServlet?AA01DOCID=<%= ab.getAA01DOCID()%>&MODE=2">削除</a>
                </div>          
                </td>  
                

    </tr>
    <%
		 }
	  }
	%>

	</table>
	
	<div class="wrapper">
    </div>
	<!-- footer -->
  <footer>
<p>© All rights reserved by K</p>
  </footer>	


</body>
</html>