package co.ys;

public class FieldTest {
	int a = 10;
	int b = 10;
	
	public void method1() {
		a++;
	}
	public static void main(String[] args) {
		FieldTest fieldTest = new FieldTest();
		fieldTest.method1();
		System.out.println(fieldTest.a);
	}
}
