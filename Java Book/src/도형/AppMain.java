package 도형;

public class AppMain {

	public static void main(String[] args) {
	
		Shape s = new Rect(4,5);	// 부모 타입의 변수는 자식 객체 참조 가능 (부모 자식 간만 가능)
		s.area();	// 자식 타입이 부모 타입으로 자동 형 변환
		s.print();
		
		s = new Tri(4,5);
		s.area();
		s.print();
		
		System.out.println();
	
		Shape[] sp = new Shape[3];
		sp[0] = new Rect(4,5);
		sp[1] = new Circle(5);
		sp[2] = new Tri(4,5);
		
		for (Shape temp : sp) {		// 타입 변수 : 배열
			temp.area();
			temp.print();
		}
		
		System.out.println();
		
		Drawable[] s2 = new Drawable[3];
		s2[0] = new Rect(4,5);
		s2[1] = new Circle(5);
		s2[2] = new Tri(4,5);
		
		for (Drawable temp : s2) {	
			temp.draw();
			if (temp instanceof Rect) {
				((Rect)temp).area();
				((Rect)temp).print();		// 부모 타입이 자식 타입으로 형 변환 시 캐스팅 필수				
			} else if (temp instanceof Circle) {
				((Circle)temp).area();
				((Circle)temp).print();
			} else if (temp instanceof Tri) {
				((Tri)temp).area();
				((Tri)temp).print();
			}
			//if (temp instanceof Shape) {
				//((Shape)temp).area();
				//((Shape)temp).print();
			if (temp instanceof Movable) {
				((Movable)temp).move();
			}
		}
	}
}
