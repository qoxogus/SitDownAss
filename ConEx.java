package JavaProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConEx {

	public static void main(String[] args) {
		
		// �ڹ� ����Ŭ JDBC �����ϱ�
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				Connection con=null;
				Statement st=null;
				ResultSet rs=null;
				String sql="select * from person";
				
				//JDBC����̹��� �޸𸮿� �ø���
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					System.out.println("JDBC ����̹��� �޸𸮿� �ø��� ��...");
					
					//DB�� �����ؼ� Connection��ü �����ϱ�
					con=DriverManager.getConnection(url, "BAE", "12345");
					System.out.println("DB���� ����");
					
					st=con.createStatement();//sql�� ����;
					rs=st.executeQuery(sql); //sql�� ���� ����� ����
					
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
					System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�.");
				} catch (SQLException e) {
//					e.printStackTrace();
					System.out.println("DB���� ����");
				}
		
		
		
		
		
		
	}

}
