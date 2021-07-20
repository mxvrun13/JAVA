package fullCalendar;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import comment.DAO;

public class CalDAO extends DAO {

	public List<FullCalendar> getSchedules() {
		connect();
		List<FullCalendar> list = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from full_calendar");
			rs = psmt.executeQuery();
			while (rs.next()) {
				FullCalendar cal = new FullCalendar();
				cal.setTitle(rs.getString("title"));
				cal.setStartDate(rs.getString("start_date"));
				cal.setEndDate(rs.getString("end_date"));
				list.add(cal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public String insertSchedule(FullCalendar cal) {
		String sql = "insert into full_calendar values(?,?,?)";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cal.getTitle());
			psmt.setString(2, cal.getStartDate());
			psmt.setString(3, cal.getEndDate());
			int r = psmt.executeUpdate();
			if (r>0) {
				System.out.println(r+"건 등록 완");
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return "fail";
	}
	
	public String deleteSchedule(FullCalendar cal) {
		String sql = "delete from full_calendar where title=?";
		connect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cal.getTitle());
//			psmt.setString(2, cal.getStartDate());
//			psmt.setString(3, cal.getEndDate());
			int r = psmt.executeUpdate();
			if (r>0) {
				System.out.println(r+"건 삭제 완");
				return "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return "fail";
	}
}
