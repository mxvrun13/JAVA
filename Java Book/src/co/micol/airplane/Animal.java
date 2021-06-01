package co.micol.airplane;

public abstract class Animal {	// 하나라도 추상 메서드가 포함되면 클래스도 추상 선언, 추상 메서드와 일발 메서드 모두 사용 가능 (인터페이스는 추상만)
	
	public void run() {
		System.out.println("뛰다");
	}
	
	public abstract void eat();		// 추상 메서드는 {}바디가 없음
	
	public void sleep() {
		System.out.println("자다");
	}

}
