package co.ys.star;

public class BreakLableTest {

	public static void main(String[] args) {
		Outer: 
		for (int i=0 ; i<9 ; i++) {
			for (int j=0 ; j<9 ; j++) {
				System.out.println(j);
				if(j==2) {
					break Outer;
				}
			}
		}
		System.out.println("end");
	}
}
