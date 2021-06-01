package 클래스;

// 1. 클래스 선언
public class Robot {
	
	// *필드
	private int arm; // private : 외부에서 변경 금지, 클래스 내부에서만 접근 가능
	private int leg;
	private String name;
	
	// *setter : private 필드값 변겅	
	public void setArm(int arm) {
		this.arm = arm;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public void setName(String name) {
		this.name = name;
	}
	// *getter : private 필드값 조회, 리턴값 필요
	public int getArm() {
		return this.arm;
	}
	public int getLeg() {
		return this.leg;
	}
	public String getName() {
		return this.name;
	}
	
	
	// *생성자 - 필드 초기화
	// public Robot() {}	// 기본 생성자
	// 생성자 오버로딩
	public Robot (int arm, int leg) {	// 생성자는 리턴 타입 없음
		this.arm = arm;		//this 전역 변수 (참조 변수) = 지역 변수
		this.leg = leg;
	}
	
	public Robot (int arm, int leg, String name) {	
		this.arm = arm;	
		this.leg = leg;
		this.name = name;
	}
	
	// *일반 메서드
	void print() {	// default는 같은 패키지 내에서만 접근 가능
		System.out.printf("arm : %d, leg : %d", arm, leg);
		System.out.println();
	}
}
