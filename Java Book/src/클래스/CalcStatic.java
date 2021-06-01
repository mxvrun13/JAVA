package 클래스;

public class CalcStatic {
	
	// static : 모든 객체가 공유하는 필드, 스택과 별도로 static 영역 존재, static에 pi 저장
	final static double PI = 3.14;		// final : 상수 (static 이면서 final), 변경 불가

	@Override
	public String toString() {
		return "CalcStatic [pi=" + PI + "]";
	}
	
	// 메서드 앞에도 static 가능
	public static int add (int inNum1, int inNum2) {
		return inNum1 + inNum2;
	}
}
