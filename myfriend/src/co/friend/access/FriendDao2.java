package co.friend.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.friend.model.Friend;
import co.friend.util.DAO;

public class FriendDao2 extends DAO implements FriendAccess{
	
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
	public void update(Friend friend) {
		sql = "update friend set tel = ? where name = ?";
		psmt.setString(1, friend );
		
	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Friend> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Friend findName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Friend findTel(String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
