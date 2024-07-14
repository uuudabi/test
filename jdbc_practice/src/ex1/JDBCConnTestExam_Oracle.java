package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCConnTestExam_Oracle {

	public static void main(String[] args) {
		 
		
		String sql = "select sno, sname, major, avr from student where major='생물'";
	
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		
	
				
		try {

		
			Class.forName(driver);
			con = DriverManager.getConnection(url, "system", "1234");
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);    // select 쿼리를 실행할 때만 executeQuery 메서드를 사용한다.
			
			System.out.println("학번      성명      전공      학점");
			System.out.println("=============================");
			while(rs.next()) {
				System.out.print(rs.getString(1) + "\t ");
				System.out.print(rs.getString(2) + "\t ");
				System.out.print(rs.getString(3) + "\t ");
				System.out.print(rs.getString(4) + "\n ");
			}
			
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
