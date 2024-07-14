package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBCConnTest03_Oracle02 {

	public static void main(String[] args) {
		 
		String sql = "insert into goodsinfo values(?, ?, ?, ?)";   //?는 바인딩 변수라고 한다. 
	
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null;
		PreparedStatement stmt = null;

		
		String code, name, maker;
		int price;
		Scanner s = new Scanner(System.in);
		
		try {
			System.out.println("품목코드 : ");
			code = s.nextLine();
			System.out.println("상품명 : ");
			name = s.nextLine();
			System.out.println("가격 : ");
			price = Integer.parseInt(s.nextLine());
			System.out.println("제조사 : ");
			maker = s.nextLine();

			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "system", "1234");
			stmt = con.prepareStatement(sql);
			stmt.setString(1, code);
			stmt.setString(2, name);
			stmt.setInt(3, price);
			stmt.setString(4, maker);
			
			int resultCount = stmt.executeUpdate();
			
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
