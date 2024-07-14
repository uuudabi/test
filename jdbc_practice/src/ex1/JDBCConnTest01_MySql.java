package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCConnTest01_MySql {

	public static void main(String[] args) {
		
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mysql";
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "1234");
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
