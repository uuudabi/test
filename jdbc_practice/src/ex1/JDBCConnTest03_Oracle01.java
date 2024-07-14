package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnTest03_Oracle01 {

	public static void main(String[] args) {
		
//		String sql = "insert into goodsinfo values('A004', 'LG-38156', 2500000, 'LGE')";
		String sql = "insert into goodsinfo values('A006', 'LG-38156', 2500000, 'LGE')";
	
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		Statement stmt = null;

		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "system", "1234");
			stmt = con.createStatement();
			
			int resultCount = stmt.executeUpdate(sql);     //영향을 미친 행의 숫자가 반환
			
			System.out.println("DB Connetion OK!");
		} catch (Exception e) {
			System.out.println("DB Connetion failure");
			e.printStackTrace();
		}
		
		finally {
			try {
				if(con != null) con.close();
				if(stmt != null) stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
