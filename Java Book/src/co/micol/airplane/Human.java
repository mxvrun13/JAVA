package co.micol.airplane;

public class Human extends Animal{		// 하위 클래스는 추상 메서드를 반드시 오버라이딩 해야 한다
	
	public void think() {
		System.out.println("생각하다");
	}

	@Override
	public void eat() {
		System.out.println("고기를 먹는다");
	}

}
