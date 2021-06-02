package pkg.friend ;

import java.util.List;

import pkg.Friend;

public class FriendManager implements FriendAccess{
	Friend[] friends = new Friend[5];
	
	
	public FriendManager() {
		friends[0] = new CompanyFriend("예담회사", "홍길동","01000000000");
		friends[1] = new SchoolFriend("중앙초등", "김기자","01011111111");
		friends[2] = new SchoolFriend("중앙고등", "윤동주","01022222222");
		friends[3] = new CompanyFriend("현대", "이상화","01033333333");
		friends[4] = new CompanyFriend("삼성", "유관순","01055555555");
	}


	@Override
	public void insert(Friend friend) {
		
	}

	@Override
	public void update(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List selectAll() {
		System.out.println("FriendManager");
		return null;
	}

	@Override
	public Friend selectOne(Object key) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
