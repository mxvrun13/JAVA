package co.ys.test;

// 사원 관리, 사원 정보 
public class Employee {
	int employeeId;
	String name;
	int departmentId;
	String departmentName;
	int salary;
	String email;
	
	public Employee() {
		this(0, "", 0, 0, "");
	}
	
	public Employee(int employeeId, String name) {
		this(employeeId, name, 0, 0, "");
	}

	public Employee(int employeeId, String name, String email) {
		this(employeeId, name, 0, 0, email);
	}

	public Employee(int employeeId, String name, int salary) {
		this(employeeId, name, 0, salary, "");
	}

	public Employee(int employeeId, String name, int departmentId, int salary, String email) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		
		if (departmentId == 0) {
			departmentId = 30;
		this.departmentId = departmentId;
		}
		
		if (departmentId == 10) {
			departmentName = "인사";
		} else if (departmentId == 20) {
			departmentName = "개발";
		} else if (departmentId == 30) {
			departmentName = "영업";
		}
		this.salary = salary;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", salary=" + salary + ", email=" + email + "]";
	}


}
