package co.ys.test;

import java.util.Scanner;

public class EmployeeApp {
	
	Scanner scanner = new Scanner(System.in);
	Employee[] employee = new Employee[10];
	int cnt = 0;

	void init() {
	System.out.println("사원 수 입력 > ");
	cnt = scanner.nextInt();
	}	
	
	void input() {
		for (int i=0 ; i < cnt ; i++) {
			System.out.println("사번 : ");
			int employeeId = scanner.nextInt();
			System.out.println("이름 : ");
			String name = scanner.next();
			System.out.println("급여 : ");
			int salary = scanner.nextInt();
			employee[i] = new Employee(employeeId, name, salary);	
		}
	}
	
	void print() {
		for (int i = 0 ; i<cnt ; i++) {
			System.out.println(employee[i]);
		}
	}
	
	String search(int num) {
		String name = "";
		for (int i = 0 ; i < cnt ; i++ ) {
			if(num == employee[i].employeeId) {
				name = employee[i].name;
			} else {
				System.out.println("일치하는 사번이 없습니다.");
			}
		}
		return name;
	}
	
	int sum() {
		int total = 0;
		for (int i = 0 ; i < cnt ; i++ ) {
			total += employee[i].salary;
		}
		return total;
	}
}	

