package 클래스;

public class EqualTest {

	public static void main(String[] args) {
		
		Robot r1 = new Robot(2,4);
		Robot r2 = new Robot(1,4);
		System.out.println(r1==r2);		// false, 1. 스택에 r1,r2 생성 (주소값 가짐), 힙에 2,4 2,4 생성, 주소가 같은지 비교
		System.out.println(r1.equals(r2));	// 오버라이딩 안하면 주소 비교 false
		System.out.println(r1);		// toString 생략됨, 원래는 주소 출력 
		
//		Robot r3 = new Robot(2,4);
//		Robot r4 = r3;
//		System.out.println(r3==r4);		// true, 같은 주소값
		
		String a = new String("hello");
		String b = new String("hello");
		System.out.println(a==b);		// false
		System.out.println(a.equals(b));	// true, equals
	}

}
