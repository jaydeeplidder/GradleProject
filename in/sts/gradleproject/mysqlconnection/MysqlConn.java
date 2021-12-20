package in.sts.gradleproject.mysqlconnection;


import java.sql.*;


public class MysqlConn  {

	public static Connection Connecivity() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		String url="jdbc:mysql://localhost:3306/jaydeep";
		String user="root";
		String pass="root";
		
	
		Connection con=DriverManager.getConnection(url,user,pass);
		return con;
		
	}
}
