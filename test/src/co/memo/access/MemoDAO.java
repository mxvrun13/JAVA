package co.memo.access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.memo.model.Memo;

// MemoAccess를 구현하는 클래스입니다.
// 기능을 작성하세요.
public class MemoDAO implements MemoAccess {
	
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	String sql;
	Memo memo = new Memo();

	@Override
	public void write(String date, String title, String content) {		// 메모 추가
		connect();
		sql = "insert into memo values (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			psmt.setString(2, title);
			psmt.setString(3, content);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void update(String title, String content) {		// 메모 수정
		connect();
		sql = "update memo set content = ? where title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setString(2, title);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(String title) {		// 메모 삭제
		connect();
		sql = "delete from memo where title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void FindAll() {		// 전체 조회
		connect();
		sql = "select * from memo";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				memo.print();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void FindByDate(String date) {		// 날짜로 조회
		connect();
		sql = "select * from memo where date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			while(rs.next()) {
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				memo.print();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void FindByContent(String content) {		// 내용 일부 검색 가능
		connect();
		sql = "select * from memo where content like ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+content+"%");
			rs = psmt.executeQuery();
			while(rs.next()) {
				memo.setDate(rs.getString("date"));
				memo.setTitle(rs.getString("title"));
				memo.setContent(rs.getString("content"));
				memo.print();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public boolean checkTitle(String title) {		// 수정, 삭제 시 메모 유무 확인 메서드
		boolean b = false;
		connect();
		sql = "select title from memo where title = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, title);
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
