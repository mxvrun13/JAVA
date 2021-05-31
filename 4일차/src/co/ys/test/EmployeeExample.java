package co.ys.test;

public class EmployeeExample {
	
	public static void main(String[] args) {
	Employee emp0 = new Employee();
	System.out.println(emp0);
	
	Employee emp1 = new Employee(100, "홍길동");
	System.out.println(emp1);
	
	Employee emp2 = new Employee(101, "김유신", "a@a.c");
	System.out.println(emp2);
	
	Employee emp3 = new Employee(102, "유관순", 2500);
	System.out.println(emp3);
	
	Employee emp4 = new Employee(103, "김영서", 10, 2500, "b@b.c");
	System.out.println(emp4);
	}
}
