package beans;

import java.math.BigDecimal;
import java.security.Timestamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class AA01Beans_01 {

	private BigDecimal AA01DOCID;

	private BigDecimal AA01SAKUSEMD;

	private String AA01CATE1;

	private String AA01CATE2;

	private String AA01GAIYOU;

	private String AA01SYOUSAI;

	private String AA01SANKOU;

	private String AA01USERID;

	private String ZZ01USERNAME;

	// private Timestamp AA01TIMESTAMP;

	public AA01Beans_01(BigDecimal aA01DOCID2, BigDecimal aA01SAKUSEMD2, String aA01CATE12, String aA01CATE22,
			String aA01GAIYOU2, String aA01SYOUSAI2, String aA01SANKOU2, String aA01USERID2) {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public AA01Beans_01() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

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

//	public Timestamp getAA01TIMESTAMP() {
//		return AA01TIMESTAMP;
//	}
//
//	public void setAA01TIMESTAMP(Timestamp aA01TIMESTAMP) {
//		AA01TIMESTAMP = aA01TIMESTAMP;
//	}


	/* 以下、SQL操作 */

	int paramcount = 1;  // パラメータ格納カウント用変数  因みにstaticにすると初期化されず、値を保持しつづける
	
	// 検索(フォームより)
	public  List<AA01Beans_01> Search01(String[] AA01CATE1, String[] AA01CATE2, String AA01GAIYOU,
			String ZZ01USERNAME) {
		Connection conn = null;
		List<AA01Beans_01> aa01 = new ArrayList<AA01Beans_01>();
		
		try {

			// データベースへ接続
			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection(
//					"jdbc:mysql://localhost:3306/company_db?characterEncoding=UTF-8&serverTimezone=JST", "suser",
//					"spass");
//			
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://b265cd7ac6a3a1:91a0d4a0@us-cdbr-east-03.cleardb.com/heroku_3b0ea9874ad3c67?reconnect=true&characterEncoding=UTF-8&serverTimezone=JST", "b265cd7ac6a3a1 ",
					"91a0d4a0");
			
			
			
			System.out.println("MySQLに接続できました。");

			// 検索
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT ");
			sb.append("AA01DOCID");
			sb.append(",AA01SAKUSEMD");
			sb.append(",AA01CATE1");
			sb.append(",AA01CATE2");
			sb.append(",AA01GAIYOU");
			sb.append(",ZZ01USERNAME ");
			sb.append("FROM ");
			sb.append("aa01 ");
			sb.append("INNER" + "  " + "JOIN" + "  " + "ZZ01  ");
			sb.append("ON  AA01USERID = ZZ01USERID ");
			sb.append("WHERE ");
			sb.append("1=1 ");

			// フォームに入力された場合は、パラメーターの?を追加する
			if (AA01CATE1 != null) {
				sb.append("AND" + " " + "AA01CATE1" + " " + "IN(");
				sb.append(preparePlaceHolders(AA01CATE1.length));
				sb.append(")");
				sb.append(" ");
			}


			if (AA01CATE2 != null) {
				sb.append("AND" + " " + "AA01CATE2" + " " + "IN(");
				sb.append(preparePlaceHolders(AA01CATE2.length));
				sb.append(")");
				sb.append(" ");
			}
			
			if(AA01GAIYOU != "") {
				sb.append("AND" + " " + "AA01GAIYOU" + " " + "LIKE"+ " " + "?");
				sb.append(" ");
			}
			
			if(ZZ01USERNAME != "") {
				sb.append("AND" + " " + "ZZ01USERNAME" + " " + "LIKE"+ " " + "?");
				
				
				sb.append(" ");
			}
			
			sb.append("ORDER BY AA01SAKUSEMD DESC");
			
			

			System.out.println("SQL文：" + sb.toString());

			PreparedStatement psmt = conn.prepareStatement(sb.toString());

			// パラメーターの?に代入する
			if (AA01CATE1 != null) {
				setValues(psmt, AA01CATE1);
			}

			
			if (AA01CATE2 != null) {
				setValues(psmt, AA01CATE2);
			}
			
			if (AA01GAIYOU != "") {
				psmt.setObject(paramcount, "%" + AA01GAIYOU + "%");
			}
			
			if (ZZ01USERNAME != "") {
				psmt.setObject(paramcount, "%" +ZZ01USERNAME+ "%");
			}
			
			
			
			//SQL文の実行
			ResultSet rs = psmt.executeQuery();
			System.out.println("SQL文：" + sb.toString());
			System.out.println("SQL成功しました");
			
			while (rs.next()) {

				// aa01Beans型にしないとリストにaddできないため、以下のようにインスタンスを生成する
				AA01Beans_01 a = new AA01Beans_01();

				a.setAA01DOCID(rs.getBigDecimal("AA01DOCID"));
				a.setAA01SAKUSEMD(rs.getBigDecimal("AA01SAKUSEMD"));
				a.setAA01CATE1(rs.getString("AA01CATE1"));
				a.setAA01CATE2(rs.getString("AA01CATE2"));
				a.setAA01GAIYOU(rs.getString("AA01GAIYOU"));
				a.setZZ01USERNAME(rs.getString("ZZ01USERNAME"));

				// aa01Beans a = new
				// aa01Beans(rs.getBigDecimal("AA01DOCID"),rs.getBigDecimal("AA01SAKUSEMD"),rs.getString("AA01CATE1"),rs.getString("AA01CATE2"),rs.getString("AA01GAIYOU"),rs.getString("AA01SYOUSAI"),rs.getString("AA01SANKOU"),rs.getString("AA01USERID"));
				aa01.add(a);
			}
			
			
			conn.close();
			psmt.close();
			rs.close();
			
			
			return aa01;
			
			
			
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

	// PreparedStatement IN句の加工用メソッド1
	public  String preparePlaceHolders(int length) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length;) {
			buffer.append("?");
			if (++i < length) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}

	// PreparedStatement IN句の加工用メソッド2
		
	public void setValues(PreparedStatement preparedStatement, String[] checkbox) throws SQLException {
		
		for (int i = 0; i < checkbox.length; i++, paramcount++) {
			System.out.println("");
			preparedStatement.setObject(paramcount, checkbox[i]);
		}
	}

}
