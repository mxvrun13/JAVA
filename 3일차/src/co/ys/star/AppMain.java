package co.ys.star;

public class AppMain {

	public static void main(String[] args) {
		StarApp star = new StarApp();
		//star.draw(5);
		//System.out.println();
		//star.drawInvert(5);
		//System.out.println();
		//star.drawEq(5);
		//System.out.println();
		//star.drawEqInvert(5);
		
		star.drawTitle("나무",100);
		star.drawEq(5);
		star.drawEq(2, 6);
		star.drawEq(4, 8);
		star.drawRect(4);
	}

}
