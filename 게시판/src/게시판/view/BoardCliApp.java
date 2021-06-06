package 게시판.view;

import java.util.List;

import 게시판.access.BoardList;
import 게시판.model.Board;
import 게시판.util.ScannerUtil;

public class BoardCliApp {
	
	BoardList boardList = new BoardList();
	
	public void start() {
		int num;
		do {
			menuTitle();
			num = ScannerUtil.readInt("번호 입력 > ");
			switch (num) {
			case 1 : insert(); break;
			case 2 : update(); break;
			case 3 : delete(); break;
			case 4 : selectAll(); break;
			case 5 : selectOne(); break;
			}
		} while (num != 0);
	}
	

	private void menuTitle() {
	System.out.println("====게시판====");
	System.out.println("1. 게시글 추가");
	System.out.println("2. 게시글 수정");
	System.out.println("3. 게시글 삭제");
	System.out.println("4. 전체 조회");
	System.out.println("5. 게시글 검색");
	System.out.println("0. 종료");
	}
	
	private void insert() {
		Board board = ScannerUtil.readBoard();
		boardList.insert(board);
	}
	
	private void update() {
		Board board = new Board();
		board.setTitle(ScannerUtil.readStr());
		board.setContent(ScannerUtil.readStr());
		boardList.update(board);
	}
	
	private void delete() {
		String title = ScannerUtil.readStr();
		boardList.delete(title);
	}
	
	private void selectAll() {
		List<Board> board = boardList.selectAll();
		for (Board b : board) {
			System.out.println(b);
		}
	}
	private void selectOne() {
		String title = ScannerUtil.readStr();		
		Board board = boardList.selectOne(title);	
		System.out.println(board);}
	}

