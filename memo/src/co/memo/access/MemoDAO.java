package co.memo.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.memo.model.Memo;
import co.memo.util.DAO;

public class MemoDAO extends DAO implements MemoAccess{
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public void insert(Memo memo) {
		sql = "insert into memo values (?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memo.getDate());
			psmt.setString(2, memo.getContent());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Memo memo) {
		sql = "update memo set content = ? where date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, memo.getContent());
			psmt.setString(2, memo.getDate());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String date) {
		sql = "delete from memo where date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Memo> selectAll() {
		ArrayList<Memo> memoList = new ArrayList<>();
		sql = "select * from memo";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Memo memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setContent(rs.getString("content"));
				memoList.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memoList;
	}

	@Override
	public Memo findDate(String date) {
		Memo memo = null;
		sql = "select * from memo where date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			while(rs.next()) {
				memo = new Memo();
				memo.setDate(rs.getString("date"));
				memo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memo;
	}

	@Override
	public Memo findContent(String content) {
		Memo memo = null;
		sql = "select * from memo where content = '?'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, content);
			rs = psmt.executeQuery();
			while(rs.next()) {
				memo.setDate(rs.getString("date"));
				memo.setContent(rs.getString("content"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memo;
	}

}
