package co.reserve.model;

public class Member {
	
	private String id;
	private String pass;
	
	
	public Member() {}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	@Override
	public String toString() {
		return "회원 [id=" + id + ", pass=" + pass + "]";
	}
	
}
