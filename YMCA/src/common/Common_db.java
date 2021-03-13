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
	
	
	
	//採番用
	
	public BigDecimal Count() {
		Connection conn = null;		
		try {

			// データベースへ接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/company_db?characterEncoding=UTF-8&serverTimezone=JST", "suser",
					"spass");
			System.out.println("MySQLに接続できました。");

			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("MAX(AA01DOCID)  AS AA01DOCID ");
			sb.append("FROM  AA01");

			System.out.println("SQL文：" + sb.toString());

			PreparedStatement psmt = conn.prepareStatement(sb.toString());
			
			//SQL文の実行
			ResultSet rs = psmt.executeQuery();
			System.out.println("SQL文：" + sb.toString());
			System.out.println("SQL成功しました");
		
			
			BigDecimal AA01DOCID = new BigDecimal(0);
			BigDecimal ONE = new BigDecimal(1);
			
			//最大値を取り、+1
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
