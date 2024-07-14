package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class JDBCConnTestExam02_Oracle {

	public static void main(String[] args) {
		 
		String sql = "select sno, sname, major, avr from student where major=?";
	
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		
	
				
		try {
			System.out.print("전공을 입력하세요.>");
			
			Scanner s = new Scanner(System.in);
		
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "system", "1234");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, s.nextLine());
			rs = stmt.executeQuery();    // select 쿼리를 실행할 때만 executeQuery 메서드를 사용한다.
			
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
