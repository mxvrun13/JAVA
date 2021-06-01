package 도형;

public abstract class Shape {	// 추상 메서드가 하나라도 존재하면 클래스도 추상
	
	int w;
	double result;
	
	public Shape() {}
	public Shape(int w) {
		this.w = w;
	}
	
	public void print() {
		System.out.println("면적 = " + result);
	}
	
	public abstract void area();	// 바디가 없는 추상 메서드, 자식에서 반드시 오버라이딩

}
