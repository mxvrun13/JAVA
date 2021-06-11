package co.memo.access;

public interface MemoAccess {
	public void write(String date, String title, String content);
	public void update(String title, String content);
	public void delete(String title);
	public void FindAll();
	public void FindByDate(String date);
	public void FindByContent(String content);
}
