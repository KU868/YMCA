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
	     * �폜
		 */
		if (MODE == 2) {
			AA01 a1 = new AA01(request, AA01DOCID, MODE);
			//�폜
			a1.DB_OPERATION(MODE);	
			request.setAttribute("message2", "�폜���܂���");
		}
		
		// �t�H���[�h �����̓]�����@1 ���ړI ����JSP�Ɍ��ʂ�߂�
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);
		
		
		// ���_�C���N�g �����̓]�����@2 �o�R/�ԐړI �����T�[�u���b�g���w�肵�āA���̐��JSP��\�������� �A�v���P�[�V�������قȂ�ꍇ�g�p
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
		 * �V�K�o�^
		 */
		if (MODE == 0) {
			// �̔Ԃ���
			Common_db cb = new Common_db();
			AA01DOCID = cb.Count();
			// �C���X�^���X�����Ɠ����ɃR���X�g���N�^��set����
			AA01 a1 = new AA01(request, AA01DOCID, MODE);

			// �V�K�o�^
			a1.DB_OPERATION(MODE);

		/*
	     * �X�V
		 */
		} else if (MODE == 1) {
			AA01 a1 = new AA01(request, AA01DOCID, MODE);
			//�X�V
			a1.DB_OPERATION(MODE);
		}
		// �t�H���[�h �����̓]�����@1 ���ړI ����JSP�Ɍ��ʂ�߂�
		request.setAttribute("message1", "�ۑ����܂���");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Input.jsp?AA01DOCID="+ AA01DOCID +"&MODE=1");
		dispatcher.forward(request, response);

	}

}
