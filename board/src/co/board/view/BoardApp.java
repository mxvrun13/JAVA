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
	
	String loginid = null;
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
		System.out.println("      6. 댓글");
		System.out.println("      0. 종료");
		System.out.println("==================");
	}
	
	public void start() {
		
		if (loginCheck()) {
			int num;
			do {
				title();
				System.out.println("입력 > ");
				num = scanner.nextInt();
				switch (num) {
				case 1: selectAll(); break;
				case 2: insert(); break;
				case 3: update(); break;
				case 4: delete(); break;
				case 5: selectOne(); break;
				case 6: comment(); break;
				}
			} while (num != 0);
		} else {
			System.out.println("권한이 없습니다.");
		}
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
//		System.out.println("작성자 > ");
//		String writer = scanner.next();
		Board board = new Board (title,content,loginid);	
		dao.insert(board);
	}

	private void update() {
		System.out.println("수정할 글 번호 > ");
		int id = scanner.nextInt();
		Board b = dao.selectOne(id);
		BoardDAO dao = new BoardDAO();
		if (dao.checkId(id)) {
			if (loginid.equals(b.getWriter())) {
				String content = null;
				System.out.println("수정할 내용 > ");
				try {
					content = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Board board2 = new Board(id, content);
				dao.update(board2);
			} else {
				System.out.println("권한이 없습니다.");
			}
		} else {
			System.out.println("존재하지 않는 글 번호 입니다.");
		}
	}

	private void delete() {
		System.out.println("삭제할 글 번호 > ");
		int id = scanner.nextInt();
		Board b = dao.selectOne(id);
		BoardDAO dao = new BoardDAO();
		if (dao.checkId(id)) {
			if (loginid.equals(b.getWriter())) {
				dao.delete(id);
			} else {
				System.out.println("권한이 없습니다.");
			}
		} else {
			System.out.println("존재하지 않는 글 번호 입니다.");
		}
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
		int num = 0;
		BoardDAO dao = new BoardDAO();
		Board board = new Board();
		do {
			System.out.println("1. 댓글 조회, 2. 댓글 등록, 0. 이전 메뉴로");
			num = scanner.nextInt();
			switch (num) {
			case 1 : 
				System.out.println("댓글을 조회할 글 번호 > ");
				int id1 = scanner.nextInt();
				List<Board> list = dao.commentSelect(id1);
				if (list.size() == 0 ) {
					System.err.println("댓글이 없습니다.");
				} else {
					for (Board b : list) {
						System.out.println("Board [글 번호=" + b.getId() + ", 댓글=" + b.getContent() + "]");					
					}
				}
				break;
			case 2 : 
				System.out.println("댓글을 작성할 글 번호 >");
				int id2 = scanner.nextInt();
				if (dao.checkId(id2)) {
					System.out.println("댓글 작성 > ");
					String content = null;
					try {
						content = br.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
					board = new Board(id2, content);
					dao.commentInsert(board);					
				} else {
					System.err.println("없는 글 번호 입니다.");
				}
				break;
			}
		} while(num!=0);		
	}
	
//	private void login() {
//		System.out.println("id > ");
//		String id = scanner.next();
//		System.out.println("password > ");
//		String pass = scanner.next();
//		BoardDAO dao = new BoardDAO();
//		dao.login(id,pass);
//	}
	
	private boolean loginCheck() {
		boolean b = false;
		BoardDAO dao = new BoardDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("id >");
		loginid = sc.next();
		System.out.println("pass >");
		String pass = sc.next();
		String str = dao.login(loginid, pass);
		if (str.equals("로그인 성공")) {
			b = true;
		}
		return b;
	}
}
