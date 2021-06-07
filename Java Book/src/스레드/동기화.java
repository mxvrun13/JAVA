package 스레드;

public class 동기화 {

	public static void main(String[] args) {
		
		// 공유 객체에 여러 스레드가 접근 시 동기화 필요 (순서 부여)
		Calculator calc = new Calculator();
		
		User1 user1 = new User1();	// 2초 대기
		user1.setCalculator(calc);
		
		User2 user2 = new User2();	// 2초 대기
		user2.setCalculator(calc);
		
		user1.start();
		user2.start();
		
	}

}
