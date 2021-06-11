package co.board.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.board.model.Board;

public class BoardDAO implements BoardAccess {
	
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	String sql;
	
	@Override
	public ArrayList<Board> selectAll() {
		connect();
		ArrayList<Board> boardList = new ArrayList<>();
		sql = "select * from board where b_parent_id is null";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("b_id"));
				board.setTitle(rs.getString("b_title"));
				board.setContent(rs.getString("b_content"));
				board.setWriter(rs.getString("b_writer"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardList;
	}

	@Override
	public void insert(Board board) {
		connect();
		sql = "insert into board (b_title,b_content,b_writer) values (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 등록 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void update(Board board) {
		connect();
		sql = "update board set b_content = ? where b_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getContent());
			psmt.setInt(2, board.getId());
			int r = psmt.executeUpdate();
			if(r != 0) {
				System.out.println(r+"건 수정 완");
			} else {
				System.err.println("존재하지 않는 글 번호 입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(int id) {
		connect();
		sql = "delete from board where b_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			if(r != 0) {
				System.out.println(r+"건 삭제 완");
			} else {
				System.err.println("존재하지 않는 글 번호 입니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public Board selectOne(int id) {
		connect();
		Board board = new Board();
		sql = "select * from board where b_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				board.setId(rs.getInt("b_id"));
				board.setTitle(rs.getString("b_title"));
				board.setContent(rs.getString("b_content"));
				board.setWriter(rs.getString("b_writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return board;
	}
	
	public ArrayList<Board> commentSelect(int id) {
		connect();
		ArrayList<Board> boardList = new ArrayList<>();
		sql = "select b_content from board where b_parent_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setId(id);
				//board.setTitle(rs.getString("b_title"));
				board.setContent(rs.getString("b_content"));
				//board.setWriter(rs.getString("b_writer"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardList;
	}
	
	public void commentInsert(Board board) {
		connect();
		sql = "insert into board (b_title,b_content,b_writer,b_parent_id) values ('댓글',?,'댓글 작성자',?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getContent());
			psmt.setInt(2, board.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 등록 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public boolean checkId (int id) {	// 글 번호 존재 유무 확인
		sql = "select * from board where b_id = ?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false;
	}
	
	public String login(String id, String pass) {
		String str = null;
		if(idCheck(id)) {
			if(passCheck(pass)) {
				str = "로그인 성공";				
			} else {
				str = "비밀번호가 틀렸습니다.";
			}
		} else {
			str = "존재하지 않는 id입니다.";
		} 
		return str;
	}
	
	public boolean idCheck(String id) {
		boolean b = false;
		connect();
		sql = "select u_id from member where u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				b = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}
	
	public boolean passCheck(String pass) {
		boolean b = false;
		connect();
		sql = "select u_pass from member where u_pass = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pass);
			rs = psmt.executeQuery();
			if(rs.next()) {
				b = true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}

	
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결 성공");	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
