package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AA01;
import beans.AA01Beans_01;
import common.Common_check;
import common.Common_db;

@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int MODE = Integer.parseInt(request.getParameter("MODE"));
		BigDecimal AA01DOCID = new BigDecimal(request.getParameter("AA01DOCID"));
		
		/*
	     * 削除
		 */
		if (MODE == 2) {
			AA01 a1 = new AA01(request, AA01DOCID, MODE);
			//削除
			a1.DB_OPERATION(MODE);	
			request.setAttribute("message2", "削除しました");
		}
		
		// フォワード 処理の転送方法1 直接的 検索JSPに結果を戻す
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);
		
		
		// リダイレクト 処理の転送方法2 経由/間接的 検索サーブレットを指定して、その先のJSPを表示させる アプリケーションが異なる場合使用
		// response.sendRedirect("/YMCA/SearchServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//doGet(request, response);
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		int MODE = Integer.parseInt(request.getParameter("MODE"));
		BigDecimal AA01DOCID = new BigDecimal(request.getParameter("AA01DOCID"));
		
		
		/*
		 * 新規登録
		 */
		if (MODE == 0) {
			// 採番する
			Common_db cb = new Common_db();
			AA01DOCID = cb.Count();
			// インスタンス生成と同時にコンストラクタでsetする
			AA01 a1 = new AA01(request, AA01DOCID, MODE);

			// 新規登録
			a1.DB_OPERATION(MODE);

		/*
	     * 更新
		 */
		} else if (MODE == 1) {
			AA01 a1 = new AA01(request, AA01DOCID, MODE);
			//更新
			a1.DB_OPERATION(MODE);
		}
		// フォワード 処理の転送方法1 直接的 検索JSPに結果を戻す
		request.setAttribute("message1", "保存しました");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Input.jsp?AA01DOCID="+ AA01DOCID +"&MODE=1");
		dispatcher.forward(request, response);

	}

}
