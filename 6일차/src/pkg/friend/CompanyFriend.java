package pkg.friend;

public class CompanyFriend extends Friend {
	
	String duty;

	public CompanyFriend() {
		super();
	}
	
	public CompanyFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);
	}

	public CompanyFriend(String gubun, String name, String tel, String duty) {
		super(gubun, name, tel);
		this.duty = duty;
	
	}

	@Override
	public void print() {
		//super.print();	// 부모 print() 호출
		//System.out.println("duty : " + duty);
		System.out.printf("회사 친구 : %20s %20s %20s %20s\n", gubun, name, tel, duty);
	}
}
