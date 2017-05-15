package bean;

public class Title {
	private int IDTitle;
	private String Title;
	private String Path;
	private String Meaning;
	public int getIDtitle() {
		return IDTitle;
	}
	public void setIDtitle(int iDTitle) {
		IDTitle = iDTitle;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getMeaning() {
		return Meaning;
	}
	public void setMeaning(String meaning) {
		Meaning = meaning;
	}
	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Title(int iDTitle, String title, String path, String meaning) {
		super();
		IDTitle = iDTitle;
		Title = title;
		Path = path;
		Meaning = meaning;
	}
}
