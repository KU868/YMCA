package beans;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import common.Common;
import common.Common_check;


public class AA01 {
	private BigDecimal AA01DOCID;

	private BigDecimal AA01SAKUSEMD;

	private String AA01CATE1;

	private String AA01CATE2;

	private String AA01GAIYOU;

	private String AA01SYOUSAI;

	private String AA01SANKOU;

	private String AA01USERID;

	public BigDecimal getAA01DOCID() {
		return AA01DOCID;
	}

	public void setAA01DOCID(BigDecimal aA01DOCID) {
		AA01DOCID = aA01DOCID;
	}

	public BigDecimal getAA01SAKUSEMD() {
		return AA01SAKUSEMD;
	}

	public void setAA01SAKUSEMD(BigDecimal aA01SAKUSEMD) {
		AA01SAKUSEMD = aA01SAKUSEMD;
	}

	public String getAA01CATE1() {
		return AA01CATE1;
	}

	public void setAA01CATE1(String aA01CATE1) {
		AA01CATE1 = aA01CATE1;
	}

	public String getAA01CATE2() {
		return AA01CATE2;
	}

	public void setAA01CATE2(String aA01CATE2) {
		AA01CATE2 = aA01CATE2;
	}

	public String getAA01GAIYOU() {
		return AA01GAIYOU;
	}

	public void setAA01GAIYOU(String aA01GAIYOU) {
		AA01GAIYOU = aA01GAIYOU;
	}

	public String getAA01SYOUSAI() {
		return AA01SYOUSAI;
	}

	public void setAA01SYOUSAI(String aA01SYOUSAI) {
		AA01SYOUSAI = aA01SYOUSAI;
	}

	public String getAA01SANKOU() {
		return AA01SANKOU;
	}

	public void setAA01SANKOU(String aA01SANKOU) {
		AA01SANKOU = aA01SANKOU;
	}

	public String getAA01USERID() {
		return AA01USERID;
	}

	public void setAA01USERID(String aA01USERID) {
		AA01USERID = aA01USERID;
	}
	
	
	BigDecimal ZERO = new BigDecimal(0);
	
	
	// コンストラクタ
	public AA01(HttpServletRequest request, BigDecimal AA01DOCID, int MODE) {
	
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("USERID");
		System.out.println(id);
		BigDecimal AA01SAKUSEMD = new BigDecimal(0);
		
		//エスケープ処理
		String AA01GAIYOU = request.getParameter("AA01GAIYOU");
		String AA01SYOUSAI = request.getParameter("AA01SYOUSAI");
		AA01GAIYOU = Common_check.Escape(AA01SYOUSAI);
		AA01SYOUSAI = Common_check.Escape(AA01GAIYOU);		
		
		if (MODE == 0) { // 新規登録
			if(request.getParameter("AA01SAKUSEMD") != null && request.getParameter("AA01SAKUSEMD") != ""){
			AA01SAKUSEMD = new BigDecimal(request.getParameter("AA01SAKUSEMD").replace("-", ""));
			}
			setAA01DOCID(Common.nvlnum(AA01DOCID, ZERO));
			setAA01SAKUSEMD(Common.nvlnum(AA01SAKUSEMD, ZERO));
			setAA01CATE1(Common.nvl(request.getParameter("AA01CATE1"), ""));
			setAA01CATE2(Common.nvl(request.getParameter("AA01CATE2"), ""));
			setAA01GAIYOU(Common.nvl(AA01GAIYOU, ""));
			setAA01SYOUSAI(Common.nvl(AA01SYOUSAI, ""));
			setAA01SANKOU(Common.nvl(request.getParameter("AA01SANKOU"), ""));
			setAA01USERID(Common.nvl(id, ""));
		} else if (MODE == 1) { // 更新
			if(request.getParameter("AA01SAKUSEMD") != null && request.getParameter("AA01SAKUSEMD") != ""){
				AA01SAKUSEMD = new BigDecimal(request.getParameter("AA01SAKUSEMD").replace("-", ""));
			}
			setAA01DOCID(Common.nvlnum(AA01DOCID, ZERO));
			setAA01SAKUSEMD(Common.nvlnum(AA01SAKUSEMD, ZERO));
			setAA01CATE1(Common.nvl(request.getParameter("AA01CATE1"), ""));
			setAA01CATE2(Common.nvl(request.getParameter("AA01CATE2"), ""));
			setAA01GAIYOU(Common.nvl(AA01GAIYOU, ""));
			setAA01SYOUSAI(Common.nvl(AA01SYOUSAI, ""));
			setAA01SANKOU(Common.nvl(request.getParameter("AA01SANKOU"), ""));
			setAA01USERID(Common.nvl(id, ""));
		} else if (MODE == 2) { // 削除
			setAA01DOCID(Common.nvlnum(AA01DOCID, ZERO));
		}
	}

	public void DB_OPERATION(int MODE) {

		Connection conn = null;

		try {

			// データベースへ接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://b265cd7ac6a3a1:91a0d4a0@us-cdbr-east-03.cleardb.com/heroku_3b0ea9874ad3c67?reconnect=true&characterEncoding=UTF-8&serverTimezone=JST", "b265cd7ac6a3a1 ",
					"91a0d4a0");
			System.out.println("MySQLに接続できました。");

			if (MODE == 0) {

				// 登録
				String sql_INS = "INSERT INTO aa01(AA01DOCID, AA01SAKUSEMD, AA01CATE1, AA01CATE2, AA01GAIYOU, AA01SYOUSAI, AA01SANKOU, AA01USERID) values "
						+ "('" + AA01DOCID + "','" + AA01SAKUSEMD + "','" + AA01CATE1 + "','" + AA01CATE2 + "','"
						+ AA01GAIYOU + "','" + AA01SYOUSAI + "','" + AA01SANKOU + "','" + AA01USERID + "');";

				System.out.println("SQL文：" + sql_INS.toString());

				PreparedStatement psmt = conn.prepareStatement(sql_INS.toString());

				// SQL文の実行
				psmt.executeUpdate();
				System.out.println("SQL成功しました");
				conn.close();
				psmt.close();

			} else if (MODE == 1) {

				// 更新
				StringBuilder sb = new StringBuilder();
				sb.append("UPDATE  ");
				sb.append("aa01 ");
				sb.append("SET ");
				sb.append("AA01SAKUSEMD = ? ");
				sb.append(",AA01CATE1 = ? ");
				sb.append(",AA01CATE2 = ? ");
				sb.append(",AA01GAIYOU = ? ");
				sb.append(",AA01SYOUSAI = ? ");
				sb.append(",AA01SANKOU = ? ");
				sb.append(",AA01USERID = ? ");
				sb.append("WHERE ");
				sb.append("AA01DOCID = ?  ");
				sb.append(";");

				PreparedStatement psmt = conn.prepareStatement(sb.toString());

				// パラメーターの?に代入する
				psmt.setObject(1, AA01SAKUSEMD);
				psmt.setObject(2, AA01CATE1);
				psmt.setObject(3, AA01CATE2);
				psmt.setObject(4, AA01GAIYOU);
				psmt.setObject(5, AA01SYOUSAI);
				psmt.setObject(6, AA01SANKOU);
				psmt.setObject(7, AA01USERID);
				psmt.setObject(8, AA01DOCID);

				System.out.println("SQL文：" + sb.toString());

				// SQL文の実行
				psmt.executeUpdate();
				System.out.println("SQL成功しました");
				conn.close();
				psmt.close();

			} else if (MODE == 2 && AA01DOCID !=null && AA01DOCID !=ZERO) {
			// 削除
			String sql_DEL = "delete from aa01 where AA01DOCID=" + AA01DOCID;
			
			System.out.println("SQL文：" + sql_DEL.toString());

			PreparedStatement psmt = conn.prepareStatement(sql_DEL.toString());

			// SQL文の実行
			psmt.executeUpdate();
			System.out.println("SQL成功しました");
			conn.close();
			psmt.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

	}

}
