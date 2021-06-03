package pkg.friend;

public class SchoolFriend extends Friend {
	
	String birth;
	
	public SchoolFriend() {}
	
	public SchoolFriend(String gubun, String name, String tel) {
		super(gubun, name, tel);	// 부모 생성자 호출
	}

	public SchoolFriend(String gubun, String name, String tel, String birth) {
		super(gubun, name, tel);
		this.birth = birth;
	
	}
	
	@Override
	public void print() {
		//super.print();	// 부모 print() 호출
		//System.out.println("duty : " + duty);
		System.out.printf("학교 친구 : %20s %20s %20s %20s\n", gubun, name, tel, birth);
	}
}
