package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMySql {
	
	public static Connection createConnectionMySQL() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_devtour?user=root&password=12345678");
		 return connection;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionMySQL();
		
		if (con != null) {
			System.out.println(con + "\n***Conexão bem sucedida***\n");
			
		con.close(); 
		}
	}
}
