package co.memo.view;

import java.util.List;

import co.memo.access.MemoAccess;
import co.memo.access.MemoDAO;
import co.memo.model.Memo;
import co.memo.util.ScannerUtil;


public class MemoCliApp {
	
	MemoAccess memoList = new MemoDAO();
	
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
			case 5 : findDate(); break;
			case 6 : findContent(); break;
			}
		} while (menunum != 0);
	}
	

	private void menuTitle() {
		System.out.println("====메모 관리====");
		System.out.println("1. 메모 추가");
		System.out.println("2. 메모 수정");
		System.out.println("3. 메모 삭제");
		System.out.println("4. 전체 조회");
		System.out.println("5. 날짜 검색");
		System.out.println("6. 내용 검색");
		System.out.println("0. 종료");
	}

	private void insert() {
		Memo memo = ScannerUtil.readMemo();
		memoList.insert(memo);
	}

	private void update() {		// 띄어쓰기 안됨
		Memo memo = new Memo();
		memo.setDate(ScannerUtil.readDate());
		memo.setContent(ScannerUtil.readStr());
		memoList.update(memo);
		
	}

	private void delete() {
		String date = ScannerUtil.readDate();
		memoList.delete(date);
		
	}

	private void selectAll() {
		List<Memo> list = memoList.selectAll();
		for (Memo memo : list) {
			System.out.println(memo);
		}
	}

	private void findDate() {
		String date = ScannerUtil.readDate();
		Memo memo = memoList.findDate(date);
		System.out.println(memo);
		
	}
	
	private void findContent() {	// 숫자일 때 안됨
		String content = ScannerUtil.readStr();
		Memo memo = memoList.findContent(content);
		System.out.println(memo);
	
	}
}
