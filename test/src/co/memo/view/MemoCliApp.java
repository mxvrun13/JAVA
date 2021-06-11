package co.memo.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;

public class MemoCliApp {

	MemoAccess access = new MemoDAO(); // 데이터베이스 입출력 처리하세요.
	Scanner scanner = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	

	public void start() {
		int menuNum;

		do {
			menuTitle();
			System.out.print("입력 > ");
			menuNum = scanner.nextInt();
			switch (menuNum) {
			case 1 : insert(); break;
			case 2 : update(); break;
			case 3 : delete(); break;
			case 4 : selectAll(); break;
			case 5 : FindByDate(); break;
			case 6 : FindByContent(); break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}

	private void insert() {
		String date;
		while (true) {
			System.out.println("날짜(yyyy-MM-dd) > ");
			date = scanner.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.out.println("날짜 형식이 올바르지 않습니다. ex) 1900-01-01");
			}
		}

		System.out.println("제목 > ");
		String title = null;
		try {
			title = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("내용 > ");
		String content = null;
		try {
			content = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		access.write(date, title, content);
	}

	private void update() {		// 제목 입력 시 내용 수정
		String title = null;
		System.out.println("수정할 메모의 제목 > ");
		MemoDAO md = new MemoDAO();
		try {
			title = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(md.checkTitle(title)) {
			System.out.println("수정할 내용 > ");
			String content = null;
			try {
				content = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			access.update(title,content);
		} else {
			System.out.println("존재하지 않는 메모 입니다.");
		}
	}

	private void delete() {		// 제목 입력 시 내용 삭제
		String title = null;
		System.out.println("삭제할 메모의 제목 > ");
		MemoDAO md = new MemoDAO();
		try {
			title = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(md.checkTitle(title)) {
			access.delete(title);
		} else {
			System.out.println("존재하지 않는 메모 입니다.");
		}
	}

	private void selectAll() {
		access.FindAll();
	}

	private void FindByDate() {		// 날짜 입력 시 해당 매모 조회
		String date;
		while (true) {
			System.out.println("날짜(yyyy-MM-dd) > ");
			date = scanner.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.out.println("날짜 형식이 올바르지 않습니다. ex) 1900-01-01");
			}
		}
		access.FindByDate(date);
	}

	private void FindByContent() {		// 메모 내용 입력 시 해당 메모 조회 (내용 일부만 입력해도 가능)
		System.out.println("메모 내용 검색 > ");
		String content = null;
		try {
			content = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		access.FindByContent(content);
	}

	private void menuTitle() {
		System.out.println("=== 메모 관리 ===");
		System.out.println("=1. 메모 추가");
		System.out.println("=2. 메모 수정");
		System.out.println("=3. 메모 삭제");
		System.out.println("=4. 전체 조회");
		System.out.println("=5. 날짜로 조회");
		System.out.println("=6. 내용으로 조회");
		System.out.println("=0. 종료");
		System.out.println("===============");

	}

}
