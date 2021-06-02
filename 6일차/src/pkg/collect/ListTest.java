package pkg.collect;

import java.util.ArrayList;

import pkg.Friend;
import pkg.friend.CompanyFriend;
import pkg.friend.SchoolFriend;

public class ListTest {
	
	public static void main(String[] args) {
		ArrayList<Friend> list = new ArrayList<Friend>();	// <배열에 담을 타입>
		list.add(new Friend("현대", "홍", "1111"));
		list.add(0, new CompanyFriend("삼성", "김", "2222"));	// (인덱스 위치, 값)
		list.add(new SchoolFriend("초등", "이", "3333"));
		// 전체 조회
		for(Friend li : list) {
			System.out.println(li.getName());
		}
		System.out.println("=====");
		// 삭제
		list.remove(0);
		for(Friend li : list) {
			System.out.println(li.getName());
		}
		Friend fr = list.get(0);
		System.out.println("첫번째 이름 : " + fr.getName());
		// 마지막 이름 조회
		System.out.println("마지막 이름 : " + list.get(list.size()-1).getName());
		
		list.set(1, new Friend ("중학교", "최", "5555"));
		for(Friend f : list) {
			System.out.println(f.getName());
		}
		
	}
}
