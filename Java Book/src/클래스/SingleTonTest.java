package 클래스;

public class SingleTonTest {

	public static void main(String[] args) {
		Calcurator c1 = Calcurator.getInstance();
		c1.add(10, 20);
		
		Calcurator c2 = Calcurator.getInstance();
		c2.add(10, 20);
	
		System.out.println(c1 == c2);
	}

}
