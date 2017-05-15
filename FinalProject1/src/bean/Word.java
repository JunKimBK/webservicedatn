package bean;

public class Word {
	private int IDWord;
	private int IDTitle;
	private String Word;
	private String Meaning;
	private String Picture;
	private String Sound;
	public int getIDWord() {
		return IDWord;
	}
	public void setIDWord(int iDWord) {
		IDWord = iDWord;
	}
	public int getIDTitle() {
		return IDTitle;
	}
	public void setIDTitle(int iDTitle) {
		IDTitle = iDTitle;
	}
	public String getWord() {
		return Word;
	}
	public void setWord(String word) {
		Word = word;
	}
	public String getMeaning() {
		return Meaning;
	}
	public void setMeaning(String meaning) {
		Meaning = meaning;
	}
	public String getPicture() {
		return Picture;
	}
	public void setPicture(String picture) {
		Picture = picture;
	}
	public String getSound() {
		return Sound;
	}
	public void setSound(String sound) {
		Sound = sound;
	}
	public Word(int iDWord, int iDTitle, String word, String meaning, String picture, String sound) {
		super();
		IDWord = iDWord;
		IDTitle = iDTitle;
		Word = word;
		Meaning = meaning;
		Picture = picture;
		Sound = sound;
	}
	public Word() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
