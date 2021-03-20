package beans;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.Common;


public class ZZ01 {

	private String ZZ01USERID;

	private String ZZ01USERNAME;

	public String getZZ01USERID() {
		return ZZ01USERID;
	}

	public void setZZ01USERID(String zZ01USERID) {
		ZZ01USERID = zZ01USERID;
	}

	public String getZZ01USERNAME() {
		return ZZ01USERNAME;
	}

	public void setZZ01USERNAME(String zZ01USERNAME) {
		ZZ01USERNAME = zZ01USERNAME;
	}

	
	public ZZ01 ZZ01_Search(String id) {
		
			ZZ01 zz01 = new ZZ01();
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
				sb.append("ZZ01USERID  AS ZZ01USERID");
				sb.append(",ZZ01USERNAME  AS ZZ01USERNAME  ");
				sb.append("FROM ZZ01  ");
				sb.append("WHERE  ");
				sb.append("ZZ01USERID =  ?");
				
				

				System.out.println("SQL���F" + sb.toString());

				PreparedStatement psmt = conn.prepareStatement(sb.toString());

				// �p�����[�^�[��?�ɑ������
	            psmt.setObject(1, id);
			
				//SQL���̎��s
				ResultSet rs = psmt.executeQuery();
				System.out.println("SQL���F" + sb.toString());
				System.out.println("SQL�������܂���");
				
				
				//�������ʂ��Ȃ��ꍇ��""������
				 if(rs.next() == false ) {
					 zz01.setZZ01USERID("");
					 zz01.setZZ01USERNAME("");
		         } else {
		             zz01.setZZ01USERID(Common.nvl(rs.getString("ZZ01USERID"),""));
					 zz01.setZZ01USERNAME(Common.nvl(rs.getString("ZZ01USERNAME"),""));
//		             do {
//		            	 zz01.setZZ01USERID(Common.nvl(rs.getString("ZZ01USERID"),""));
//						 zz01.setZZ01USERNAME(Common.nvl(rs.getString("ZZ01USERNAME"),""));
//		            } while (rs.next()) ;
		         }
				

				
				conn.close();
				psmt.close();
				rs.close();
				
				return zz01;
				

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
