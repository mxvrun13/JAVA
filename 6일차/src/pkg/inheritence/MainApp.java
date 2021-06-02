package pkg.inheritence;

public class MainApp {

	public static void main(String[] args) {
		A a = new D();	// 자동 형 변환
		int temp = ((D)a).sd;	// 강제 형 변환
		
		A o = new A();
		temp = ((D)o).sd;	// 실행(런타임) 오류
		
		System.out.println(a instanceof A);
		System.out.println(a instanceof B);
		System.out.println(a instanceof D);
		System.out.println(a instanceof X);
		
		B b = new D();
		Y y = new D();
		
		// B b = new B();
		b = new D();
		// b = new C();
	}

}
