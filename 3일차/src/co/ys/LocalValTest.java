package co.ys;

public class LocalValTest {
	
	int a;
	int b;
	
	public void method1() {
		int a = 10;
		method2();
		{
			int b = 10;
			b++;
		}
		System.out.println(a + " : " + b);
	}
	public void method2() {
		int a = 20;
		a++;
	}
	public static void main(String[] args) {
		int a = 100;
		LocalValTest local = new LocalValTest();
		local.method1();
		System.out.println(a);
	}

}
