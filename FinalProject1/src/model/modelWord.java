package model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Word;

public class modelWord {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	modelConnectDb mcd = new modelConnectDb();
	
	public ArrayList<Word> getList(){
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
	
	public ArrayList<Word> getListWordOfIDTitle(int IDtitle){
		ArrayList<Word> alWord = new ArrayList<>();
		String sql = "Select * from Word where IDtitle = "+IDtitle+"";
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
	
	public int DeleteWord(int idWord){
		int result = 0;
		String sql = "Delete from Word where IDWord = ?";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, idWord);
			ps.executeUpdate();
			result = 1;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Word getWord(int idWord){
		Word word = null;
		String sql = "Select * from Word where IDWord = ?";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, idWord);
			rs = ps.executeQuery();
			if(rs.next()){
				int IDWord = rs.getInt("IDWord");
				int IDTitle = rs.getInt("IDTitle");
				String Word = rs.getString("Word");
				String Meaning = rs.getString("Meaning");
				String Picture = rs.getString("Picture");
				String Sound = rs.getString("Sound");
				word = new Word(IDWord, IDTitle, Word, Meaning, Picture, Sound);
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
		return word;
	}
	
	public int UpdateWord(Word word){
		int result = 0;
		String sql = "Update Word set IDTitle = ?, Word = ?, Meaning = ?, Picture = ?, Sound = ? where IDWord =?";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, word.getIDTitle());
			ps.setString(2, word.getWord());
			ps.setString(3, word.getMeaning());
			ps.setString(4, word.getPicture());
			ps.setString(5, word.getSound());
			ps.setInt(6, word.getIDWord());
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
	
	public int InsertWord(Word word){
		int result =0;
		String sql = "Insert into Word(IDTitle, Word, Meaning, Picture, Sound) VALUES(?,?,?,?,?)";
		con = mcd.getConnectionSQLite();
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, word.getIDTitle());
			ps.setString(2, word.getWord());
			ps.setString(3, word.getMeaning());
			ps.setString(4, word.getPicture());
			ps.setString(5, word.getSound());
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
