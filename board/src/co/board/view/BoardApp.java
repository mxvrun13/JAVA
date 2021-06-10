package co.board.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import co.board.access.BoardAccess;
import co.board.access.BoardDAO;
import co.board.model.Board;

public class BoardApp {
	
	Scanner scanner = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BoardAccess dao = new BoardDAO();
	
	public void title() {
		System.out.println("==== 게시판 목록 ====");
		System.out.println("    1. 전체 조회");
		System.out.println("   2. 게시물 등록");
		System.out.println("   3. 게시물 수정");
		System.out.println("   4. 게시물 삭제");
		System.out.println("   5. 게시물 검색");
		System.out.println("     6. 댓글");
		System.out.println("     0. 종료");
		System.out.println("==================");
	}
	
	public void start() {
		int num;
		do {
			title();
			System.out.println("입력 > ");
			num = scanner.nextInt();
			switch (num) {
			case 1 : selectAll(); break;
			case 2 : insert(); break;
			case 3 : update(); break;
			case 4 : delete(); break;
			case 5 : selectOne(); break;
			case 6 : comment(); break;
			}
		} while(num!=0);

	}
	
	private void selectAll() {
		List<Board> list = dao.selectAll();
		for (Board b : list) {
			System.out.println("Board [id=" + b.getId() + ", title=" + b.getTitle() + ", writer=" + b.getWriter() + "]");
		}
	}

	private void insert() {
		System.out.println("제목 > ");
		String title = null;
		try {
			title = br.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String content = null;
		System.out.println("내용 > ");
		try {
			content = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("작성자 > ");
		String writer = scanner.next();
		Board board = new Board (title,content,writer);	
		dao.insert(board);
	}

	private void update() {
		System.out.println("수정할 글 번호 > ");
		int id = scanner.nextInt();
		
		String content = null;
		System.out.println("수정할 내용 > ");
		try {
			content = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Board board = new Board(id,content);
		dao.update(board);
	}

	private void delete() {
		System.out.println("삭제할 글 번호 > ");
		int id = scanner.nextInt();
		dao.delete(id);
	}

	private void selectOne() {
		System.out.println("조회할 글 번호 > ");
		int id = scanner.nextInt();
		Board board = dao.selectOne(id);
		System.out.println(board);
	}

	private void comment() {
//		System.out.println("댓글을 달 글 번호 > ");
//		int id = scanner.nextInt();
		BoardDAO dao = new BoardDAO();
		System.out.println("1. 댓글 조회, 2. 댓글 등록, 0. 이전 메뉴로");
		int num = scanner.nextInt();
		if (num==1) {
			System.out.println(dao.commentSelect());
			
		}
		
	}
}
