package co.ys.app;

public class Calc {
	
	public static int add(int a, int b) {
		return a+b;
	}
	public static int div(int a, int b) throws NumberFormatException, ArrayIndexOutOfBoundsException{	// throws시 호출한 쪽에서 예외처리 필수
		int c = 0;
//		try {
//			c = a/b;
//			return c;
//		} catch (ArithmeticException e){
//			c = a;
//		}
		c = a/b;
		return c;
	}
}
