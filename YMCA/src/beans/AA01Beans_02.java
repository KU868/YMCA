package beans;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//�ҏW�p��ʁ@beans

public class AA01Beans_02 {
	private BigDecimal AA01DOCID;

	private BigDecimal AA01SAKUSEMD;

	private String AA01CATE1;

	private String AA01CATE2;

	private String AA01GAIYOU;

	private String AA01SYOUSAI;

	private String AA01SANKOU;

	private String AA01USERID;
	
	private String ZZ01USERNAME;


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
	
	public String getZZ01USERNAME() {
		return ZZ01USERNAME;
	}

	public void setZZ01USERNAME(String zZ01USERNAME) {
		ZZ01USERNAME = zZ01USERNAME;
	}
	
	
	/* �ȉ��ASQL���� */
	
	// ����(�t�H�[�����)
	
	//AA01Beans_02 a2 = new AA01Beans_02(); �O���ŃC���X�^���X������ƂȂ���stack overfrow���o�Ă��܂��B
	public AA01Beans_02 Search02(BigDecimal AA01DOCID, int MODE) {
		AA01Beans_02 a2 = new AA01Beans_02();
		Connection conn = null;
		
		
		try {

			// �f�[�^�x�[�X�֐ڑ�
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://b265cd7ac6a3a1:91a0d4a0@us-cdbr-east-03.cleardb.com/heroku_3b0ea9874ad3c67?reconnect=true&characterEncoding=UTF-8&serverTimezone=JST", "b265cd7ac6a3a1 ",
					"91a0d4a0");
			System.out.println("MySQL�ɐڑ��ł��܂����B");

			// ����   ����ID MODE��0��������V�K�@MODE��1��������ҏW
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("0 AS AA01DOCID");
			sb.append(",0  AS AA01SAKUSEMD");
			sb.append(",''  AS AA01CATE1");
			sb.append(",'' AS AA01CATE2");
			sb.append(",'' AS AA01GAIYOU");
			sb.append(",'' AS AA01SYOUSAI");
			sb.append(",'' AS AA01SANKOU");
			sb.append(",'' AS AA01USERID");
			sb.append(",'' AS ZZ01USERNAME ");
			sb.append("FROM ");
			sb.append("aa01 ");
			sb.append("INNER" + "  " + "JOIN" + "  " + "ZZ01 ");
			sb.append("ON" + "  " + "AA01USERID = ZZ01USERID ");
			sb.append("WHERE ");
			sb.append("1=1 AND 0 = ? ");
			sb.append("AND  0 = ? ");
			
			sb.append("UNION  ALL ");
			
			sb.append("SELECT ");
			sb.append("AA01DOCID");
			sb.append(",AA01SAKUSEMD");
			sb.append(",AA01CATE1");
			sb.append(",AA01CATE2");
			sb.append(",AA01GAIYOU");
			sb.append(",AA01SYOUSAI");
			sb.append(",AA01SANKOU");
			sb.append(",AA01USERID");
			sb.append(",ZZ01USERNAME ");
			sb.append("FROM ");
			sb.append("aa01 ");
			sb.append("INNER" + "  " + "JOIN" + "  " + "ZZ01 ");
			sb.append("ON  AA01USERID = ZZ01USERID ");
			sb.append("WHERE ");
			sb.append("1=1 AND AA01DOCID = ? "); 
			sb.append("AND  1 = ? ");
			

			System.out.println("SQL���F" + sb.toString());

			PreparedStatement psmt = conn.prepareStatement(sb.toString());

			// �p�����[�^�[��?�ɑ������
            psmt.setObject(1, AA01DOCID);
		    psmt.setObject(3, AA01DOCID);

			psmt.setObject(2, MODE);
			psmt.setObject(4, MODE);

			
			
			//SQL���̎��s
			ResultSet rs = psmt.executeQuery();
			System.out.println("SQL���F" + sb.toString());
			System.out.println("SQL�������܂���");
		
			
			while (rs.next()) {
				a2.setAA01DOCID(rs.getBigDecimal("AA01DOCID"));
				a2.setAA01SAKUSEMD(rs.getBigDecimal("AA01SAKUSEMD"));
				a2.setAA01CATE1(rs.getString("AA01CATE1"));
				a2.setAA01CATE2(rs.getString("AA01CATE2"));
				a2.setAA01GAIYOU(rs.getString("AA01GAIYOU"));
				a2.setAA01SYOUSAI(rs.getString("AA01SYOUSAI"));
				a2.setAA01SANKOU(rs.getString("AA01SANKOU"));
				a2.setAA01USERID(rs.getString("AA01USERID"));
				a2.setZZ01USERNAME(rs.getString("ZZ01USERNAME"));

			}
			
			conn.close();
			psmt.close();
			rs.close();
			
			return a2;
			

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		

	}
}
