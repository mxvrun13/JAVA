package 도형;

public class Rect extends Shape implements Drawable, Movable{
	
	int h;
	
	public Rect(int w, int h) {
		// this.w = w;
		super(w);
		this.h = h;
	}
	
	public void area() {
		result = w*h;
	}
	
	public void draw() {
		System.out.println("직사각형 그림");
	}

	public void move() {
		System.out.println("직사각형 이동");
	}
}
