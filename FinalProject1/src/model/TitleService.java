package model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Title;

public class TitleService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	modelConnectDb mcd = new modelConnectDb();
	public ArrayList<Title> getListTitle() throws UnsupportedEncodingException{
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

}
