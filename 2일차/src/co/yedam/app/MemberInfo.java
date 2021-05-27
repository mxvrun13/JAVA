package co.yedam.app;

import java.util.Scanner;

public class MemberInfo {
		String name;	//이름
		String id;		//주민번호
		String tel;		//전화번호
		
		double height;		//키
		double weight;		//몸무게
		
		double result = 0;
		String s = "";
		
		Scanner scanner = new Scanner(System.in);
		
		void hwInput() {
			System.out.println("키 (cm) : ");
			height = scanner.nextDouble();
			System.out.println("몸무게 (kg) : ");
			weight = scanner.nextDouble();
			
		}
		
		String bmi() {
			result = weight / ((height/100)*(height/100)); 
			if(result <= 18.5) {
				s = "저체중";	
			} else if(result <= 23) {
				s = "정상";
			} else if(result <= 25) {
				s = "과체중";
			} else if(result <= 30) {
				s = "비만";
			} else {
				s="고도비만";
			}
			return s;
		}
			

		void input() {			
			System.out.println("1. 이름 : ");
			name = scanner.next();
			System.out.println("2. 주민등록번호 : ");
			id = scanner.next();
			System.out.println("3. 전화번호 : ");
			tel = scanner.next();
		}
	
		void print() {
			System.out.println("[입력한 내용]");
			System.out.println(name);
			System.out.println(id);
			System.out.println(tel);
			
		}

}
