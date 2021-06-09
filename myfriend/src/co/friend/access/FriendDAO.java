package co.friend.access;
//FriendAccess, FriendList

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import co.friend.model.Friend;
import co.friend.util.DAO;

public class FriendDAO extends DAO implements FriendAccess {
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	@Override
	public void insert(Friend friend) {
		sql = "insert into friend values (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, friend.getGubun());
			psmt.setString(2, friend.getName());
			psmt.setString(3, friend.getTel());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Friend friend) {		// 동일한 이름이 없다는 전제
		sql = "update friend set tel = ? where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,friend.getTel());
			psmt.setString(2,friend.getName());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 수정 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String name) {
		sql = "delete from friend where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,name);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제 완");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Friend> selectAll() {
		ArrayList<Friend> friendList = new ArrayList<> ();	// 반환값이 arraylist
		try {
			psmt = conn.prepareStatement("select * from friend");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Friend friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
				friendList.add(friend);		// 데이터 건 수 만큼 ArrayList에 담아 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friendList;
	}

	@Override
	public Friend findName(String name) {
		Friend friend = null;
		sql = "select * from friend where name = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
			} else {
				System.out.println("조회된 값이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friend;
	}

	@Override
	public Friend findTel(String tel) {
		Friend friend = null;
		sql = "select * from friend where tel = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, tel);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				friend = new Friend();
				friend.setGubun(rs.getString("gubun"));
				friend.setName(rs.getString("name"));
				friend.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return friend;
	}
	
	public Map<String, String> getNameTel () {
		Map<String, String> map = new HashMap<>();
		sql = "select name,tel from friend";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString("name"), rs.getString("tel"));
			}
			System.out.println(map);
//			Set<Entry<String,String>> ent = map.entrySet();		// 키와 값을 쌍으로 set에 담음
//			Iterator<Entry<String,String>> eiter = ent.iterator();
//			while(eiter.hasNext()) {
//				Entry<String,String> e = eiter.next();
//				System.out.println(e.getKey()+", "+e.getValue());
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
