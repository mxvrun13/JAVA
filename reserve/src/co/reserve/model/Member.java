package co.reserve.model;

public class Member {
	
	private String id;
	private String pass;
	private String name;


	private String tel;
	
	
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

	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getTel() {
		return tel;
	}
	
	
	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String toString() {
		return "│    " + id + "    │    " + name + "    │    " + tel + "    │";
	}

	
	
	
}
