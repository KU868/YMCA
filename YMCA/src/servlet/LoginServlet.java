package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import beans.ZZ01;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("ID");
		
		ZZ01 zz01 = new ZZ01();
		
		zz01 = zz01.ZZ01_Search(id);
		
		
		if (zz01.getZZ01USERID() == "") {
			request.setAttribute("message", "ID‚ªˆá‚¢‚Ü‚·");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("USERID", zz01.getZZ01USERID());
			session.setAttribute("USERNAME", zz01.getZZ01USERNAME());
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
			dispatcher.forward(request, response);
	
		}
	}

}
