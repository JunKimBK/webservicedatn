package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Word;

public class WordService {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	modelConnectDb mcd = new modelConnectDb();
	
	public ArrayList<Word> getListWord(){
		ArrayList<Word> alWord = new ArrayList<>();
		String sql = "Select * from Word";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int IDWord = rs.getInt("IDWord");
				int IDTitle = rs.getInt("IDTitle");
				String Word = rs.getString("Word");
				String Meaning = rs.getString("Meaning");
				String Picture = rs.getString("Picture");
				String Sound = rs.getString("Sound");
				
				Word word = new Word(IDWord, IDTitle, Word, Meaning, Picture, Sound);
				alWord.add(word);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return alWord;
	}

}
