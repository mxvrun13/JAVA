package co.reserve.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import co.reserve.access.ReserveDAO;
import co.reserve.model.Member;
import co.reserve.model.Reserve;

public class ReserveApp {
	
	String loginId;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	ReserveDAO dao = new ReserveDAO();
	Reserve r = new Reserve();
	Member m = new Member();
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	private boolean loginCheck() {
		boolean b = false;
		System.out.println("id > ");
		loginId = sc.next();
		System.out.println("pass > ");
		String pass = sc.next();
		String str = dao.login(loginId, pass);
		System.out.println(str);
		if (str.equals("*로그인 성공*")) {
			b = true; 
		}
		return b;
	}
	
	private void signUp() {
		System.out.println("가입 정보");
		System.out.println("id > ");
		String id = sc.next();
		if (dao.signUpCheck(id)) {
			System.out.println("비밀번호 > ");
			String pass = sc.next();
			System.out.println("비밀번호 확인 > ");
			String passConfirm = sc.next();
			if (pass.equals(passConfirm)) {
				dao.signUp(id, pass);
				System.out.println("회원가입이 완료되었습니다");
			} else {
				System.err.println("비밀번호가 일치하지 않습니다.");
			}			
		} else {
			System.err.println("이미 가입된 id입니다.");
		}
	}
	
	private void deleteAccount() {
		System.out.println("탈퇴할 id > ");
		String id = sc.next();
		if (dao.idCheck(id)) {
			System.out.println("비밀번호 > ");
			String pass = sc.next();
			if (dao.passCheck(pass)) {
				String result = null;
				while (true) {
					System.out.println("정말 탈퇴하시겠습니까? y/n");
					result = sc.next();
					try {
						if (result.equals("y") || result.equals("n")) {
							break;
						} else {
							System.err.println("올바르지 않은 입력입니다. y/n");
						}
					} catch (Exception e) {}
				}
				if (result.equals("y")) {
					dao.deleteAccount(id);
					System.out.println("탈퇴가 정상적으로 진행되었습니다.");
				} else {
					System.out.println("초기 화면으로 돌아갑니다.");
				}
			} else {
				System.err.println("비밀번호가 일치하지 않습니다.");
			}
		} else {
			System.err.println("존재하지 않는 id입니다.");
		}
	}

	public void loginList() {
		System.out.println("1. 로그인");
		System.out.println("2. 회원 가입");
		System.out.println("3. 회원 탈퇴");
		System.out.println("0. 종료");
	}
	
	public void adminList() {
		System.out.println("1. 전제 예약 조회");
		System.out.println("2. 날짜별 예약 조회");
		System.out.println("3. 예약 취소");
		System.out.println("0. 로그아웃");
	}

	public void memberList() {
		System.out.println("1. 예약 조회");
		System.out.println("2. 관람 예약");
		System.out.println("3. 예약 취소");
		System.out.println("0. 로그아웃");
	}

	
	public void start() {
		
		int num;
		do {
			loginList();
			System.out.println("선택 > ");
			num = sc.nextInt();
			switch (num) {
			case 1:
				if (loginCheck()) {
					int listnum;
					if (loginId.equals("admin")) {
						do {
							adminList();
							System.out.println("선택 > ");
							listnum = sc.nextInt();
							switch (listnum) {
							case 1 : adminSelectAll(); break;
							case 2 : adminSelectDate(); break;
							case 3 : adminDelete(); break;
							}
						} while (listnum != 0);
					} else {
						do {
							memberList();
							System.out.println("선택 > ");
							listnum = sc.nextInt();
							switch (listnum) {
							case 1:
							case 2:
							}
						} while (listnum != 0);
					}
					break;
				} else {
					break;
				}
			case 2 : signUp(); break;
			case 3 : deleteAccount(); break;
			}
		} while (num != 0);
	}

	private void adminSelectAll() {
		ArrayList<Reserve> list = dao.adminSelectAll();
		for (Reserve r : list) {
			System.out.println(r);
		}
	}

	private void adminSelectDate() {
		String date;
		while (true) {
			System.out.println("날짜(yyyy-MM-dd) > ");
			date = sc.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.out.println("날짜 형식이 올바르지 않습니다. ex) yyyy-mm-dd");
			}
		}
		ArrayList<Reserve> list = dao.adminSelectDate(date);
		for (Reserve r : list) {
			System.out.println(r);
		}
	}

	private void adminDelete() {
		System.out.println("예약 취소자 id > ");
		String id =  sc.next();
		String date;
		while (true) {
			System.out.println("예약 날짜(yyyy-MM-dd) > ");
			date = sc.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.out.println("날짜 형식이 올바르지 않습니다. ex) yyyy-mm-dd");
			}
		}
		dao.adminDelete(id, date);
	}
}
