package co.micol.airplane;

public class Bird extends Animal implements Flyer{

	@Override
	public void run() {
		// super.run(); = 부모 메서드 호출
		System.out.println("달린다");
	}

	@Override
	public void eat() {
		System.out.println("주로 벌레를 먹는다");
	}
	
	public void takeOff() {
		System.out.println("이륙하다");
	}
	
	public void fly() {
		System.out.println("날다");
	}
	
	public void land() {
		System.out.println("착륙하다");
	}
	
	public void layEggs() {	
		System.out.println("알을 낳다");
	}
	
}
