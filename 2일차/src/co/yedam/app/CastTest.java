package co.yedam.app;

import java.util.Scanner;

// 형 변환 테스트 

public class CastTest {

	public static void main(String[] args) {
		
		// 자동 형 변환
		int a = 10;
		long b = a;

		// 강제 형 변환
		a = (int)b;

		// char(문자) <-> int(코드)
		char c = 'Z';
		System.out.println((int)c);
		int d = 97;
		System.out.println((char)d);
		
		// 실수 -> 정수
		double e = 10.5;
		int f = (int)e;
		System.out.println(f);
		
		// 수식 내 자동 형 변환
		double g = 5 + 10.5;
		String h = "hi" + 5;
		System.out.println(g);
		System.out.println(5 + 10 + "hi");	
		
		// int/int=int
		double i = 5 / (double)2;
		System.out.println(i);
		
		// String -> int
		String s1 = "123";
		int j =  Integer.parseInt(s1);
		
		// int -> String
		String s2 = String.valueOf(123);
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력 : ");
		String greet = scanner.next();
		
		System.out.println(greet);
		
	}

}
