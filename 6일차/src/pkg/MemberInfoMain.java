package pkg;

public class MemberInfoMain {
	
	public static void main(String[] args) {
		MemberInfo member1 = MemberInfo.getInstance();	// getInstance 메소드로 memberinfo를 불러옴
		member1.names[0]="홍길동";
		MemberInfo member2 = MemberInfo.getInstance();
		member2.names[1]="김기자";
		MemberInfo member3 = MemberInfo.getInstance();
		member3.names[2]="윤동주";
		
		member1.print();
		//member2.print();
		//member3.print();
		
		
	}
}
