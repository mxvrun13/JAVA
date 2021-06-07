package 연산자;

public class 관계연산 {

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		
		if (y++>10 && x++>10) {		// ++x라면 참
			System.out.println("A");
		} else {
			System.out.println("B");
		}
		
		System.out.println(x);	// 첫 번재 관계식이 거짓이기 때문에 두 번째 관계식 계산x
		System.out.println(y);
		
		
	}

}
