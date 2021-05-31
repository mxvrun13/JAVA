package co.ys.member;

import java.util.Scanner;

public class MemberService {
	
	
	
	Member[] members = new Member[10];
	int cnt = 0;
	// 회원가입
	void insert(String name, String id, String password, int age) {
	members[cnt] = new Member(name, id, password, age);	
	cnt++;
	}
	
	void insert() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("id : ");
	String id = scanner.next();
	System.out.println("password : ");
	String password = scanner.next();
	System.out.println("name : ");
	String name = scanner.next();
	System.out.println("age : ");
	int age = scanner.nextInt();
	members[cnt] = new Member(name, id, password, age);	
	cnt++;
	}
	
	// 회원 리스트
	void printList() {
		for (int i = 0 ; i<cnt ; i++) {
			System.out.println(members[i]);
		}
	}
	
	void printMember () {
		Scanner scanner = new Scanner(System.in);
		System.out.println("번호 입력 : ");
		int i = scanner.nextInt();
		System.out.println(members[i]);
	}
	
	void login() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("id : ");
		String id = scanner.next();
		System.out.println("password : ");
		String password = scanner.next();
		for (int i = 0 ; i < cnt ; i++ ) {
			if(id.equals(members[i].id) && password.equals(members[i].password)) {
				System.out.println("로그인 되었습니다.");
			} else {
				System.out.println("로그인에 실패하였습니다.");
			}
		}
	}
	
	void select() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("id : ");
		String id = scanner.next();
		for (int i = 0 ; i < cnt ; i++ ) {
			if(id.equals(members[i].id)) {
				System.out.println(members[i]);
			} else {
				System.out.println("조회된 아이디가 없습니다.");
			}
			
			System.out.println();
		}
	}
	
	void logout(String id) {
		System.out.println("로그아웃 되었습니다");
	}
}
