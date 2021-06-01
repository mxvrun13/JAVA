package 도형;

public class Tri extends Shape implements Drawable{
	
	int h;	// 높이
	
	public Tri (int w, int h) {
		//this.w = w;
		super(w);
		this.h = h;
	}

	public void area() {
		result = w*h/2;
	}
	
	public void draw() {
		System.out.println("삼각형 그림");
	}

}
