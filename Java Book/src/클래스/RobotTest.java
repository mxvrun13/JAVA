package 클래스;

public class RobotTest {

	public static void main(String[] args) {
		// 2. 객체 생성
		Robot r = new Robot(2,4);
		// r.arm = 2; 	// 외부에서 필드 변경, private 필드는 invisible, 변경 불가
		// r.leg = 4;
		System.out.println(r.getArm());
		System.out.println(r.getLeg());
		
		Robot r2  = new Robot(2,2);
		// 3. 객체 사용 (메서드 호출)
		r2.print();
		
		Robot r3 = new Robot(2,2,"로보");
		System.out.println(r3.getArm());
		System.out.println(r3.getLeg());
		System.out.println(r3.getName());
	}

}
