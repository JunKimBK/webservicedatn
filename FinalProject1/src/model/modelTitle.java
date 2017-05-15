package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Title;

public class modelTitle {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	modelConnectDb mcd = new modelConnectDb();
	
	public ArrayList<Title> getList(){
		ArrayList<Title> alTitle = new ArrayList<>();
		String sql = "Select * from Title";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int IDTitle = rs.getInt("IDTitle");
				String Title = rs.getString("Title");
				String Path = rs.getString("Path");
				String Meaning = rs.getString("Meaning");
				
				Title tit = new Title(IDTitle, Title, Path, Meaning);
				alTitle.add(tit);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return alTitle;
	}
	
	public int DeleteTitle(int idTitle){
		int result = 0;
		String sql = "Delete from Title where IDTitle = ?";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, idTitle);
			ps.executeUpdate();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Title getTitle(int idTitle){
		Title tit = null;
		String sql = "SELECT * From Title where IDTitle=?";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, idTitle);
			rs = ps.executeQuery();
			if(rs.next()){
				int IDTitle = rs.getInt("IDTitle");
				String Title = rs.getString("Title");
				String Path = rs.getString("Path");
				String Meaning = rs.getString("Meaning");
				
				tit = new Title(IDTitle, Title, Path, Meaning);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return tit;
	}
	
	public int UpdateTitle(Title title){
		int result = 0;
		String sql = "UPDATE Title set Title = ?, Path = ?, Meaning = ? WHERE IDTitle = ?";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, title.getTitle());
			ps.setString(2, title.getPath());
			ps.setString(3, title.getMeaning());
			ps.setInt(4, title.getIDtitle());
			ps.executeUpdate();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int InsertTitle(Title title){
		int result = 0;
		String sql = "INSERT INTO Title(Title, Path, Meaning) VALUES(?,?,?)";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, title.getTitle());
			ps.setString(2, title.getPath());
			ps.setString(3, title.getMeaning());
			ps.executeUpdate();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
}
