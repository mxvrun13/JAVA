package co.ys.star;

public class ContinueTest {

	public static void main(String[] args) {
		for (int i=1 ; i<=10 ; i++) {
			if(i % 2 == 1) {
				continue;
			}
			System.out.println(i);
			if (i == 6) {				
				break;
			}
		}
	}
}
