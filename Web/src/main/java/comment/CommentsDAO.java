package comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommentsDAO extends DAO {
	private static CommentsDAO instance;
	public static CommentsDAO getInstance() {
		if (instance != null) {
			return instance;
		}
		return new CommentsDAO();
	}
	
	public void delete(Comments comment) {
		connect();
//		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement("delete from comments where id = ?");
			psmt.setString(1, comment.getId());
			psmt.executeUpdate();
			conn.commit();
			
//			map.put("id", comment.getId());
//			map.put("name", comment.getName());
//			map.put("content", comment.getContent());
//			map.put("code", "success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return map;
	}
	// 수정.. 
	public HashMap<String, Object> update(Comments comment) {
		connect();
		int currentId = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			psmt = conn.prepareStatement("select id from comments where name = ?");
			psmt.setString(1, comment.getName());
			rs = psmt.executeQuery();
			if (rs.next()) {
				currentId = rs.getInt(1);
			}
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement("update comments set name=?, content=? where id = ?");
			psmt.setString(1, comment.getName());
			psmt.setString(2, comment.getContent());
			psmt.setInt(3, currentId);
			psmt.executeUpdate();
			conn.commit(); // db commit
			map.put("id", comment.getId());
			map.put("name", comment.getName());
			map.put("content", comment.getContent());
			map.put("code", "success");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			map.put("code", "error");
		} finally {
			disconnect();
		} // auto commit 중지
		return map;
	}
	// 입력
	public HashMap<String, Object> insert(Comments comment) {
		// 현재 시퀀스 번호 = 번호+1 -> 입력 -? 시퀀스+1
		connect();
		int currentId = 0;
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select value from id_repository where name = 'COMMENT'");
			if (rs.next()) {
				currentId = rs.getInt(1);
			}
			currentId++; // 새로운 시퀀스 번호
			psmt = conn.prepareStatement("update id_repository set value=? where name='COMMENT'");
			psmt.setInt(1, currentId);
			psmt.executeUpdate();
			
			psmt = conn.prepareStatement("insert into comments(id,name,content) values (?,?,?)");
			psmt.setInt(1, currentId);
			psmt.setString(2, comment.getName());
			psmt.setString(3, comment.getContent());
			psmt.executeUpdate();
			conn.commit(); // db commit
			map.put("id", currentId);
			map.put("name", comment.getName());
			map.put("content", comment.getContent());
			
			map.put("code", "success");
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			map.put("code", "error");
		} finally {
			disconnect();
		} // auto commit 중지
		return map;
	}

	// 댓글 목록
	public List<HashMap<String, Object>> selectAll() {
		connect();
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from comments order by id"); // psmt와 달리 파라미터 사용 불가 (? 불가)
			while (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				map.put("id", rs.getInt("id")); // 테이블의 id를 받아와 리스트에 저장, id가 문자여도 숫자로 받아오기 가능
				map.put("name", rs.getString("name"));
				map.put("content", rs.getString("content"));
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
