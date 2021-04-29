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

	//doget  ���t�@�C����URL�𒼐ڒ@������A�T�[�o�Ŏ��s�����肵���Ƃ��ɓ���
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//�t�H���[�h �����̓]�����@1 ���ړI
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);
	}

	
	//dppost  �t�H�[�����Ń{�^���Ȃǉ������Ɏ��s�����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//doGet(request, response);
		
		response.setCharacterEncoding("UTF-8"); 
		request.setCharacterEncoding("UTF-8");

		
		// 1. JSP�̃t�H�[�����炨�����Ă������́@�����p�@���N�G�X�g�p�����[�^���擾
		String[] AA01CATE1 = request.getParameterValues("AA01CATE1");
		String[] AA01CATE2 = request.getParameterValues("AA01CATE2");
		String AA01GAIYOU = request.getParameter("AA01GAIYOU");
		String ZZ01USERNAME = request.getParameter("ZZ01USERNAME");
				

		
		// 2. beans �S���������\�b�h�Ăяo��
		AA01Beans_01 aa01Beans_01 = new AA01Beans_01();  //AA01Beans�N���X���C���X�^���X�����āA�ϐ��ŎQ�Ƃł���悤�ɂ���  
		List<AA01Beans_01> aa01  = aa01Beans_01.Search01(AA01CATE1,AA01CATE2,AA01GAIYOU,ZZ01USERNAME);
		
		//�擾�ł��Ă��邩�m�F�@�R���N�V�����̏ꍇ�̓��[�v�������łȂ���Beans�̃��\�b�h�������Ȃ�
		for(AA01Beans_01 ab : aa01) {
			System.out.println("�������ʂ��T�[�u���b�g�ɖ߂��Ă��Ă��邩�m�F�F" + ab.getAA01DOCID() + "  "  + ab.getAA01SAKUSEMD() + "  " + ab.getAA01CATE1());
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
		
		
		// 3. �t�H���[�h �����̓]�����@1�@���ړI   ����JSP�Ɍ��ʂ�߂�
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Search.jsp");
		dispatcher.forward(request, response);




	}




}
