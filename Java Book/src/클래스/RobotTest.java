package 클래스;

public class RobotTest {
	
	public static void change(int a) {		// 기본 변수 : 정수, 실수, 논리
		a += 10;	// 2. change 안에서만 사용되는 지역 변수, a=11, 벗어나는 순간 삭제
	}
	
	public static void change(Robot robot) {	// 참조 변수 : 배열, 열거, 클래스. 인터페이스, 2. 스택에 robot 생성, robot -> Robot(2,4) 참조
		robot.setArm(5);	// 3. 2가 5로 저장
	}

	public static void main(String[] args) {
		// 2. 객체 생성
		Robot r = new Robot(2,4);	// 1. r은 참조변수, 스택에 저장 (주소값 저장) Robot(2,4)은 힙에 저장, r -> Robot(2,4) 참조
		change(r);
		System.out.println(r.getArm());		// 4. 5 출력
		
		int a = 1;		// 1. 스택에 a=1 생성, a는 기본 변수이기 때문
		change(a);
		System.out.println(a);		//  1 출력
				
		
		// r.arm = 2; 	// 외부에서 필드 변경, private 필드는 invisible, 변경 불가
		// r.leg = 4;
//		System.out.println(r.getLeg());
		
//		Robot r2  = new Robot(2,2);
		// 3. 객체 사용 (메서드 호출)
//		r2.print();
//		
//		Robot r3 = new Robot(2,2,"로보");
//		System.out.println(r3.getArm());
//		System.out.println(r3.getLeg());
//		System.out.println(r3.getName());
	}

}
