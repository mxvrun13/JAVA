package co.reserve.view;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import co.reserve.access.ReserveDAO;
//import co.reserve.model.Member;
import co.reserve.model.Reserve;
import co.reserve.util.ScannerUtil;

public class ReserveApp {
	
	String loginId;
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Scanner sc = new Scanner(System.in);
	ReserveDAO dao = new ReserveDAO();
	//Reserve r = new Reserve();
	//Member m = new Member();
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm";
	
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
		System.out.println("이름 > ");
		String name = sc.next();	// 스캐너유틸
		System.out.println("전화번호 > ");
		String tel = sc.next();	//스캐너유틸
		System.out.println("id > ");
		String id = sc.next();
		if (dao.signUpCheck(id)) {
			System.out.println("비밀번호 > ");
			String pass = sc.next();
			System.out.println("비밀번호 확인 > ");
			String passConfirm = sc.next();
			if (pass.equals(passConfirm)) {
				dao.signUp(id, pass, name, tel);
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
					if (result.equals("y") || result.equals("n")) {
						break;
					} else {
						System.err.println("올바르지 않은 입력입니다. ex) y/n");
					}
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
		System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println( "	 			< 대구 미술관 관람 사전 예약 >"+"\n"+"\n"+
							"			1. 로그인   /   2. 회원 가입   /   3. 회원 탈퇴"+"\n"+
							"			     4. id찾기   /   5. password 찾기"+"\n"+"\n"+
							"									       exit(0)");
		System.out.println("└─────────────────────────────────────────────────────────────────────────────────────┘");
	}
	
	public void adminList() {
		System.out.println("1. 전제 예약 조회");
		System.out.println("2. 날짜별 예약 조회");
		// 유저별
		// 예약 변경
		System.out.println("3. 예약 취소");
		System.out.println("0. 로그아웃");
	}

	public void guide() {
		System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println( " 대구 미술관을 이용해주시는 시민 여러분께 감사드립니다."+"\n"+
							" 현재 전시 관람은 코로나19로 인해 사전 예약제로 운영됨을 알려드립니다."+"\n"+
							" 현장 예매는 불가하오니 관람객 분들께서는 반드시 사전 예약을 이용해 주시기 바라며,"+"\n"+
							" 방문 시 출입 명부 작성, 마스크 착용 등의 방역지침 준수를 부탁드립니다." +"\n"+
							"\n"+
							" 1. 관람은 무료입니다."+"\n"+
							"    관람 시간은 10:00~18:00이며 매주 월요일은 휴관일 입니다."+"\n"+
							" 2. 예약 시간대는 1시간 간격으로 구성되어 있으며, 정원은 회차당 80명입니다. (단, 관람시간은 제한이 없습니다.)"+"\n"+
							" 3. 관람 예약은 아이디당 1일 1회만 가능합니다."+"\n"+
							" 4. 1회 예약 인원은 아이디당 4명까지 가능합니다. (*5인 이상 집합 금지)"+"\n"+
							" 5. 코로나19 확산 방지를 위해 단체 관람은 진행하지 않습니다."+"\n"+
							" 6. 안전한 관람을 위해 회차별 입장을 진행하오니 예약 후 방문해주시기 바랍니다.");
		System.out.println("└─────────────────────────────────────────────────────────────────────────────────────┘");
	}

	public void memberList() {
		System.out.println("┌─────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println();
		System.out.println( "	 			< 대구 미술관 관람 사전 예약 >"+"\n"+"\n"+
							"		     1. 예약 조회   /   2. 관람 예약   /   3. 예약 취소"+"\n"+"\n"+
							"									    log-out(0)");
		System.out.println("└─────────────────────────────────────────────────────────────────────────────────────┘");
	}

	
	public void start() {
		
		int num;
		do {
			loginList();
			System.out.println("선택 > ");
			num = ScannerUtil.readInt();
			switch (num) {
			case 1:
				if (loginCheck()) {
					int listnum;
					if (loginId.equals("admin")) {
						do {
							adminList();
							System.out.println("선택 > ");
							listnum = ScannerUtil.readInt();
							switch (listnum) {
							case 1 : adminSelectAll(); break;
							case 2 : adminSelectDate(); break;
							case 3 : adminDelete(); break;
							}
						} while (listnum != 0);
					} else {
						guide();
						do {
							memberList();
							System.out.println("선택 > ");
							listnum = ScannerUtil.readInt();
							switch (listnum) {
							case 1 : selectAll(); break;
							case 2 : insert(); break;
							case 3 : delete(); break;
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
			System.out.println("날짜(yyyy-mm-dd) > ");
			date = sc.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.err.println("올바르지 않은 입력입니다. ex) yyyy-mm-dd");
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
			System.out.println("예약 날짜(yyyy-mm-dd) > ");
			date = sc.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.err.println("올바르지 않은 입력입니다. ex) yyyy-mm-dd");
			}
		}
		dao.adminDelete(id, date);
	}
	
	private void selectAll() {
		if (dao.selectAll(loginId).size() != 0) {
			ArrayList<Reserve> list = dao.selectAll(loginId);
			for (Reserve r : list) {
				System.out.println(r);
			}
		} else {
			System.out.println("예약 내역에 존재하지 않습니다.");
		}
	}
	
	private void insert() {
		int total = 80;
		String date = null;
		String time = null;
		int num = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String input = format.format(System.currentTimeMillis());
		while (true) {
			System.out.println("예약할 날짜(yyyy-mm-dd) > ");
			date = sc.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.err.println("올바르지 않은 입력입니다. ex) yyyy-mm-dd");
			}
		}
		if (dao.reserveCheck(loginId, date)) {
			System.err.println("예약은 1일 1회만 가능합니다.");
		} else {
			while (true) {
				System.out.println("시간을 선택해주세요 (HH:mm) > ");
				time = sc.next();
				try {
					SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
					sdf.parse(time);
					if (time != null)
						break;
				} catch (ParseException e) {
					System.err.println("올바르지 않은 입력입니다. ex) hh:mm");
				}
			}
			System.out.println("============================================="+"\n"+ 
							   " 시간 > " + time + "\t 현재 예약 가능 인원은 " + (total-dao.numCheck(date, time))+"명 입니다."+"\n"+
							   "=============================================");
			while (true) {
				System.out.println("예약 인원 > ");
				num = ScannerUtil.readInt();
				if (num <= 4) {
					break;
				} else if (num < 1) {
					System.err.println("인원은 1명 이상이어야 합니다.");
				} else {
					System.err.println("5인 이상 관람 불가입니다.");
				}
			}
			Reserve r = new Reserve(loginId, date, time, num, input);
			dao.insert(r);
		}
	}
		
	private void delete() {
		ArrayList<Reserve> list = dao.selectAll(loginId);
		for (Reserve r : list) {
			System.out.println(r);
		}
		String date = null;
		while (true) {
			System.out.println("취소할 날짜(yyyy-mm-dd) > ");
			date = sc.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.err.println("올바르지 않은 입력입니다. ex) yyyy-mm-dd");
			}
		}
		dao.delete(loginId, date);
	}
}

