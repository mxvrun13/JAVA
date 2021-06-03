package pkg.friend;

public class Friend {

	protected String gubun;
	protected String name;
	protected String tel;

	public Friend() {
		super();
	}

	public Friend(String gubun, String name, String phoneNum) {
		super();
		this.gubun = gubun;
		this.name = name;
		this.tel = phoneNum;
	}

	public void print() {
		System.out.printf("Friend: %20s %20s %20s\n", gubun, name, tel);
	}

	
	public String getCategory() {
		return gubun;
	}

	public void setCategory(String category) {
		this.gubun = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return tel;
	}

	public void setPhoneNum(String phoneNum) {
		this.tel = phoneNum;
	}

	@Override
	public String toString() {
		return "Friend [category=" + gubun + ", name=" + name + ", phoneNum="
				+ tel + "]";
	}
	
}
