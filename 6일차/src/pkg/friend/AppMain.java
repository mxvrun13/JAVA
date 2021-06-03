package pkg.friend;

public class AppMain {
	
	public static void main(String[] args) {
		Friend f1 = new CompanyFriend("회사","홍길동","01000000000","과장");
		//f1.print();
		Friend f2 = new SchoolFriend("학교","홍길동","01000000000","900101");
		//f2.print();
		
		FriendManager manager = new FriendManager();		// 인터페이스는 직접 생성 불가, 다형성 (상속, 오버로딩 시에만 가능)
		for (Friend fr : manager.friends) {		
			if (fr instanceof CompanyFriend)	// instanceof : 학교 or 회사만 출력
				fr.print();		// 부모 타입의 참조 변수가 자식 객체를 참조 가능, 메서드 실행 시 참조 대상의 메서드가 호출 되므로 결과가 다르다 
		}	
	}
}
