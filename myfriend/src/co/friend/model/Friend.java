package co.friend.model;

public class Friend {	// 클래스에 final을 걸면 상속 불가
	protected String gubun;		// protected : 상속 관계의 자식 클래스만 접근 가능
	protected String name;
	protected String tel;
	
	public Friend() {}

	public Friend(String gubun, String name, String tel) {
		super();
		this.gubun = gubun;
		this.name = name;
		this.tel = tel;
	}
	
	public void print() {	// 메소드에 final을 걸면 오버라이딩 불가
		System.out.printf("친구 : %20s %20s %20s\n", gubun, name, tel);
	}

	public String getName() {
		return name;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Friend [gubun=" + gubun + ", name=" + name + ", tel=" + tel + "]";
	}

	
}
