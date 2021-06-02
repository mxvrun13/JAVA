package pkg;

public class MemberInfo {
	// 싱글톤
	static MemberInfo memberInfo = new MemberInfo(); // MemberInfo 자체가 스태틱으로 들어감
	static MemberInfo getInstance() {	// 스태틱 메소드
		return memberInfo;
	}
	
	private MemberInfo() {}	// 외부에서 접근 불가한 기본 생성자
	
	String[] names = new String[10];
	
	void print() {
		for (String name : names) {			
			System.out.println(name);
		}
	}

}
