package JavaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConEx {

	public static void main(String[] args) {
		
		// 자바 오라클 JDBC 연결하기
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				String sql="select * from person";
				
				//JDBC드라이버를 메모리에 올리기
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("JDBC 드라이버를 메모리에 올리는 중...");
					
					//DB와 연결해서 Connection객체 생성하기
					con=DriverManager.getConnection(url, "BAE", "12345");
					System.out.println("DB연결 성공");
					
					st=con.createStatement();//sql문 실행;
					rs=st.executeQuery(sql); //sql문 실행 결과값 생성
					
//					rs.next();
//					System.out.println(rs.getString(1));
//					System.out.println(rs.getString("name"));
					
					while(rs.next()) {
						String name=rs.getString("name");
			            String phone=rs.getString("phone");
			            String email=rs.getString("email");
			            System.out.println(name+", "+phone+", "+email);
					}
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
					System.out.println("JDBC 드라이버를 찾지 못했습니다.");
				} catch (SQLException e) {
//					e.printStackTrace();
					System.out.println("DB연결 실패");
				}
		
		
		
		
		
		
	}

}
