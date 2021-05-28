package co.yedam.app;

import java.util.Scanner;

// 계산 게임 (사칙 연산, 진수 변환, 문자값 검사)

public class CalcGame {
	
	double a;
	double b;
	
	// 1~cnt까지의 합 계산
	int sum (int cnt) {
		int result = 0;
		for (int i=1; i<=cnt; i++) {
			result += i;
		}
		return result;
	}
	void input() {
		CalcGame game = new CalcGame();
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력 : ");
		String s1 = scanner.next();
		System.out.println("입력 : ");
		String s2 = scanner.next();
		
		a = Double.parseDouble(s1);
		b = Double.parseDouble(s2);
	}
	
	// 정수인 두 수의 합을 계산하는 메서드
	double add() {
		return a+b;
	}
	
	// 두 수를 나눈 몫을 계산
	int share() {
		return (int)(a/b);
	}
	
	// 두 수의 나눗셈
	double div() {
		return a/b;
	}			
	// 두 수를 나눈 나머지 계산
	int rest() {
		return (int)(a%b);
	}



}