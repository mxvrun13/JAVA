package 도형;

public class AppMain2 {

	public static void main(String[] args) {
		Shape s = new Rect(4,5);	// 부모 타입 변수가 자식 객체 참조 가능
		execute(s);
		
		s = new Circle(4);
		execute(s);
	}
	
	public static void execute(Shape s) {
		if (s instanceof Drawable) {	// instanceof : 지정 클래스의 인스턴스인지 아닌지 검사
			((Drawable)s).draw();
		}
		if (s instanceof Movable) {
			((Movable)s).move();
		}
		s.area();	// 다형성 : 참조 대상 메서드 호출
		s.print();
	}

}
