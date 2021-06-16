package co.reserve.access;

public interface MemberAccess {
	
	public boolean idCheck(String id);
	public boolean passCheck(String pass);
	public String login(String id, String pass);
	public void signUp(String id, String pass, String name, String tel);

}
