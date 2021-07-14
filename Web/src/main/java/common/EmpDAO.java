package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public List<Employee> getEmpList() {
		conn = DBCon.getConnect();
		List<Employee> empList = new ArrayList<>();
		try {
			psmt = conn.prepareStatement("select * from empl_temp");
			rs = psmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setHireDate(rs.getString("hire_date"));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}
	
	public void insertEmp(Employee emp) {
		conn = DBCon.getConnect();
		try {
			psmt = conn.prepareStatement("insert into empl_demo(employee_id, first_name, last_name, email, hire_date) values (?,?,?,?,?)");
			psmt.setInt(1, emp.getEmployeeId());
			psmt.setString(2, emp.getFirstName());
			psmt.setString(3, emp.getLastName());
			psmt.setString(4, emp.getEmail());
			psmt.setString(5, emp.getHireDate());
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
}
