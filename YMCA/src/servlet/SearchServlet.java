package servlet;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import beans.AA01Beans_01;



@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SearchServlet() {
		super();

	}

	//doget  当ファイルのURLを直接叩いたり、サーバで実行したりしたときに動く
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//フォワード 処理の転送方法1 直接的
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);
	}

	
	//dppost  フォーム内でボタンなど押下時に実行される
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//doGet(request, response);
		
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");

		
		// 1. JSPのフォームからおくられてきたもの　検索用　リクエストパラメータを取得
		String[] AA01CATE1 = request.getParameterValues("AA01CATE1");
		String[] AA01CATE2 = request.getParameterValues("AA01CATE2");
		String AA01GAIYOU = request.getParameter("AA01GAIYOU");
		String ZZ01USERNAME = request.getParameter("ZZ01USERNAME");
				

		
		// 2. beans 全権検索メソッド呼び出し
		AA01Beans_01 aa01Beans_01 = new AA01Beans_01();  //AA01Beansクラスをインスタンス化して、変数で参照できるようにする  
		List<AA01Beans_01> aa01  = aa01Beans_01.Search01(AA01CATE1,AA01CATE2,AA01GAIYOU,ZZ01USERNAME);
		
		//取得できているか確認　コレクションの場合はループ条件下でないとBeansのメソッドが動かない
		for(AA01Beans_01 ab : aa01) {
			System.out.println("検索結果がサーブレットに戻ってきているか確認：" + ab.getAA01DOCID() + "  "  + ab.getAA01SAKUSEMD() + "  " + ab.getAA01CATE1());
		}
		
		if(aa01.size()==0) {
			request.setAttribute("KEKKA","0");
		}else {
			request.setAttribute("KEKKA","1");
		}
		
		request.setAttribute("aa01", aa01);
		request.setAttribute("AA01CATE1", AA01CATE1);
		request.setAttribute("AA01CATE2", AA01CATE2);
		request.setAttribute("AA01GAIYOU", AA01GAIYOU);
		request.setAttribute("ZZ01USERNAME", ZZ01USERNAME);
		
		
		// 3. フォワード 処理の転送方法1　直接的   検索JSPに結果を戻す
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);




	}




}
