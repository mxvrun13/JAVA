package 스레드;

public class User1 extends Thread{

	private Calculator calculator;

	@Override
	public void run() {
		calculator.setMemory(100);
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
		this.setName("User1");
	}
}
