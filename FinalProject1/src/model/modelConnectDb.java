package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class modelConnectDb {
	public Connection getConnectionSQLite(){
		Connection conn = null;
		String username ="root";
		String pass = "";
		String url="jdbc:mysql://localhost:3306/jp?useUnicode=true&characterEncoding=UTF-8";
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println("Khong the nap driver");
			e.getStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, username, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String args[]){
		modelConnectDb mconnect = new modelConnectDb();
		System.out.println(mconnect.getConnectionSQLite());
	}
}
