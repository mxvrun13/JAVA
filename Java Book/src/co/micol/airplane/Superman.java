package co.micol.airplane;

// 다중 상속 안됨 - 인터페이스 사용
// 
public class Superman extends Human implements Flyer{
	
	public void takeOff() {
		System.out.println("이륙하다");
	}
	
	public void fly() {
		System.out.println("하늘을 날다");
	}
	
	public void land() {
		System.out.println("착륙하다");
	}

}
