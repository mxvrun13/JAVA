package pkg.friend;

import pkg.Friend;

public class FriendAppMain {

	public static void main(String[] args) {
		FriendList list = new FriendList();
		// 등록 테스트
		Friend f = new CompanyFriend("현대해상", "홍길동", "01000000000");
		list.insert(f);
		f = new SchoolFriend("초등", "김기자", "010011111111");
		list.insert(f);
		// 검색
		System.out.println(list.selectOne("홍길동"));
		// 수정
		f = new SchoolFriend("초등", "김기자", "010444444444");
		list.update(f);
		// 삭제
		list.delete("홍길동");
		// 전체 조회
		list.selectAll();
	}

}
