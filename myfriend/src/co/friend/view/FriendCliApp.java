package co.friend.view;

import java.util.List;

import co.friend.access.FriendList;
import co.friend.model.Friend;
import co.friend.util.ScannerUtil;

public class FriendCliApp {
	
	FriendList friendList = new FriendList();
	
	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScannerUtil.readInt("입력");
			switch (menunum) {
			case 1 : insert(); break;
			case 2 : update(); break;
			case 3 : delete(); break;
			case 4 : selectAll(); break;
			case 5 : findName(); break;
			case 6 : findTel(); break;
			}
		} while (menunum != 0);
	}
	

	private void menuTitle() {
		System.out.println("====친구 관리====");
		System.out.println("1. 친구 추가");
		System.out.println("2. 친구 수정");
		System.out.println("3. 친구 삭제");
		System.out.println("4. 전체 조회");
		System.out.println("5. 이름으로 조회");
		System.out.println("6. 전화번호로 조회");
		System.out.println("0. 종료");
	}

	private void insert() {
		Friend friend = ScannerUtil.readFriend();
		friendList.insert(friend);
	}

	private void update() {
		Friend friend = new Friend();
		friend.setName(ScannerUtil.readStr());
		friend.setTel(ScannerUtil.readStr());
		friendList.update(friend);
		
	}

	private void delete() {
		String name = ScannerUtil.readStr();
		friendList.delete(name);
		
	}

	private void selectAll() {
		List<Friend> list = friendList.selectAll();
		for (Friend friend : list) {
			System.out.println(friend);
		}
	}

	private void findName() {
		String name = ScannerUtil.readStr();
		Friend friend = friendList.findName(name);
		System.out.println(friend);
		
	}

	private void findTel() {
		String tel = ScannerUtil.readEvery();
		Friend friend = friendList.findTel(tel);
		System.out.println(friend);
	}

}

