package Ass9.Db;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conn {
	public static Connection getConn() throws IOException {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/Ass9", "root", "Ranjith1@");
			System.out.println("Connection has been made Sucessfully");

		} catch (Exception e) {

			e.printStackTrace();
		} 
		return con;
	}
}
