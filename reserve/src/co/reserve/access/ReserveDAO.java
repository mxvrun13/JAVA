package co.reserve.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.reserve.model.Member;
import co.reserve.model.Reserve;
import co.reserve.util.DAO;

public class ReserveDAO extends DAO implements ReserveAccess, MemberAccess{
	
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

	
	@Override
	public ArrayList<Reserve> adminSelectAll() {
		ArrayList<Reserve> reserveList = new ArrayList<>();
		sql = "select * from reserve order by date, time";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Reserve r = new Reserve();
				r.setId(rs.getString("u_id"));
				r.setDate(rs.getString("date"));
				r.setTime(rs.getString("time"));
				r.setNum(rs.getInt("number"));
				r.setInput(rs.getString("input"));
				reserveList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserveList;
	}
	
	@Override
	public ArrayList<Reserve> adminSelectDate(String date) {
		ArrayList<Reserve> reserveList = new ArrayList<>();
		sql = "select * from reserve where date = ? order by time";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Reserve r = new Reserve();
				r.setId(rs.getString("u_id"));
				r.setDate(rs.getString("date"));
				r.setTime(rs.getString("time"));
				r.setNum(rs.getInt("number"));
				r.setInput(rs.getString("input"));
				reserveList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserveList;
	}
	
	@Override
	public ArrayList<Member> adminMemberSelect() {
		ArrayList<Member> memberList = new ArrayList<>();
		sql = "select u_id, u_name, u_tel from member";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("u_id"));
				m.setName(rs.getString("u_name"));
				m.setTel(rs.getString("u_tel"));
				memberList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberList;
	}
	
	@Override
	public void adminDelete(String id, String date) {
		sql = "delete from reserve where u_id = ? and date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, date);
			int r = psmt.executeUpdate();
			if (r != 0) {
				System.out.println(r+"??? ?????? ???");
			} else {
				System.err.println("???????????? ?????? ?????? ???????????????.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Reserve> selectAll(String id) {
		ArrayList<Reserve> reserveList = new ArrayList<>();
		sql = "select * from reserve where u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Reserve r = new Reserve();
				r.setId(rs.getString("u_id"));
				r.setDate(rs.getString("date"));
				r.setTime(rs.getString("time"));
				r.setNum(rs.getInt("number"));
				r.setInput(rs.getString("input"));
				reserveList.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reserveList;
	}

	@Override
	public void insert(Reserve reserve) {
		sql = "insert into reserve values (?,?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reserve.getId());
			psmt.setString(2, reserve.getDate());
			psmt.setString(3, reserve.getTime());
			psmt.setInt(4, reserve.getNum());
			psmt.setString(5, reserve.getInput());
			int r = psmt.executeUpdate();
			if (r != 0) {
				System.out.println(r+"??? ????????? ??????????????? ?????????????????????.");
			} else {
				System.err.println("??????");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id, String date) {
		sql = "delete from reserve where u_id = ? and date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, date);
			int r = psmt.executeUpdate();
			if (r>0) {
				System.out.println(r+"??? ?????? ????????? ?????????????????????.");
			} else {
				System.err.println("???????????? ?????? ?????? ???????????????.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean reserveCheck(String id, String date) {
		boolean b = false;
		sql = "select * from reserve where u_id = ? and date = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, date);
			rs = psmt.executeQuery();
			if(rs.next()) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public int numCheck(String date, String time) {
		int num = 0;
		sql = "select sum(number) from reserve where date =  ? and time = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, date);
			psmt.setString(2, time);
			rs = psmt.executeQuery();
			num = rs.getInt("sum(number)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	@Override
	public boolean idCheck(String id) {
		boolean b = false;
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
		}
		return b;
	}

	@Override
	public boolean passCheck(String pass) {
		boolean b = false;
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
		}
		return b;
	}

	@Override
	public String login(String id, String pass) {
		String str = null;
		if (idCheck(id)) {
			if (passCheck(pass)) {
				str = "*????????? ??????*";
			} else {
				str = "??????????????? ???????????????.";
			}
		} else {
			str = "???????????? ?????? id ?????????.";
		}
		return str;
	}

	@Override
	public void signUp(String id, String pass, String name, String tel) {
		sql = "insert into member values (?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pass);
			psmt.setString(3, name);
			psmt.setString(4, tel);
			int r = psmt.executeUpdate();
			System.out.println(r + "??? ?????? ???");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean signUpCheck(String id) {
		boolean b = true;
		sql = "select u_id from member where u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public void deleteAccount(String id) {
		sql = "delete from member where u_id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r+"??? ?????? ???");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Member searchId(String name, String tel) {
		Member m = null;
		sql = "select u_id from member where u_name = ? and u_tel = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, tel);
			rs = psmt.executeQuery();
			while (rs.next()) {
				m = new Member();
				m.setId(rs.getString("u_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public Member searchpass(String id, String name, String tel) {
		Member m = null;
		sql = "select u_pass from member where u_id = ? and u_name = ? and u_tel = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setString(3, tel);
			rs = psmt.executeQuery();
			while (rs.next()) {
				m = new Member();
				m.setPass(rs.getString("u_pass"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

}
