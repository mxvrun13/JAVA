package 클래스;

public class CalcStaticTest {

	public static void main(String[] args) {
		
		// CalcStatic.PI = 3.141592;	// static은 객체를 생성하지 않고도 클래스명으로 직접 접근 가능
		System.out.println(CalcStatic.PI);		//final 조회는 가능
		System.out.println(CalcStatic.add(10, 20));		// static 메서드 직접 호출
		
		// Integer.MAX_VALUE = 100; : final 필드는 변경 불가
		//CalcStatic c1 = new CalcStatic();
		// CalcStatic c2 = new CalcStatic();
		
		// System.out.println(c1);
		// System.out.println(c2);
	}
	
}
