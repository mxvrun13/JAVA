package pkg.friend;

public class Friend {

	protected String gubun;
	protected String name;
	protected String tel;

	public Friend() {
		super();
	}

	public Friend(String gubun, String name, String tel) {
		super();
		this.gubun = gubun;
		this.name = name;
		this.tel = tel;
	}

	public void print() {
		System.out.printf("Friend: %20s %20s %20s\n", gubun, name, tel);
	}

	
	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
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
		return "Friend [category=" + gubun + ", name=" + name + ", phoneNum="
				+ tel + "]";
	}
	
}
