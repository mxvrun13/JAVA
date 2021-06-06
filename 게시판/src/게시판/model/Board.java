package 게시판.model;

public class Board {
	
	protected String title;
	protected String content;
	protected String date;
	
	public Board() {}
	public Board(String title, String content, String date) {
		this.title = title;
		this.content = content;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", date=" + date + "]";
	}
	
}
