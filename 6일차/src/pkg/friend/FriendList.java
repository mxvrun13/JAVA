package pkg.friend;

import java.util.ArrayList;
import java.util.List;

import pkg.Friend;

public class FriendList implements FriendAccess {
	
	List<Friend> friends;	//List는 인터페이스 ArrayList는 클래스
	
	public FriendList() {
		friends = new ArrayList<Friend>();
	}

	@Override
	public void insert(Friend friend) {
		friends.add(friend);
		
	}

	@Override
	public void update(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAll() {
		System.out.println("FriendList");
	}

	@Override
	public Friend selectOne(String name) {
		for (Friend f : friends);{
		if (f.getName().equals(name)) {
			return f;
			}
		}
		return null;
	}


}
