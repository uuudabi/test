package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCConnTest01_Oracle {

	public static void main(String[] args) {
		
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "system", "1234");
			stmt = con.createStatement();
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
