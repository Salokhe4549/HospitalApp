package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConn() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
		return conn;
	}
}
