package co.ys.test;

// 클래스 : 필드 + 메서드 + 생성자
public class Calc {
	
	// on/off, 리턴값이 없고, 매개변수도 없는 타입
	void turnOn() {
		System.out.println("계산기 on");
	}
	
	// sum, 리턴값이 없고, 매개변수 있음
	void sum(int a, int b) {
		System.out.println("int 메서드");
		System.out.println("두 수의 합 : " + (a+b));
	}
	void sum(double a, double b) {
		System.out.println("double 메서드");
		System.out.println("두 수의 합 : " + (a+b));
	}
	
	// 리턴값, 매개변수 있음
	int sum2(int a, int b) {
		return a+b;
	}
	
	// 가변인 수
	int sum3(int ... arr) {
		int result = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			result += arr[i];
		}
		return result;
	}
}
