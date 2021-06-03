package co.ys.app;

public class CalcMain {

	public static void main(String[] args) {		// static이라 바로 참조 가능
		
		int a = 10;
		int b = 0;
		int c = 0;
		try {
			c = Calc.div(a, b);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(c);
	}

}
