package common;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Common_db {
	
	
	
	//�̔ԗp
	
	public BigDecimal Count() {
		Connection conn = null;		
		try {

			// �f�[�^�x�[�X�֐ڑ�
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/company_db?characterEncoding=UTF-8&serverTimezone=JST", "suser",
					"spass");
			System.out.println("MySQL�ɐڑ��ł��܂����B");

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("MAX(AA01DOCID)  AS AA01DOCID ");
			sb.append("FROM  AA01");

			System.out.println("SQL���F" + sb.toString());

			PreparedStatement psmt = conn.prepareStatement(sb.toString());
			
			//SQL���̎��s
			ResultSet rs = psmt.executeQuery();
			System.out.println("SQL���F" + sb.toString());
			System.out.println("SQL�������܂���");
		
			
			BigDecimal AA01DOCID = new BigDecimal(0);
			BigDecimal ONE = new BigDecimal(1);
			
			//�ő�l�����A+1
			if(rs.next()) {
			AA01DOCID = rs.getBigDecimal("AA01DOCID").add(ONE);
			}else {
				
	        };
			
	        conn.close();
			psmt.close();
			rs.close();
			
			return AA01DOCID;
			

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
