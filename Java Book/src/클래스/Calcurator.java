package 클래스;


public class Calcurator {
	
	// 싱글톤, 메모리의 효율적 관리를 위한
	private static Calcurator instance = new Calcurator();
	public static Calcurator getInstance() {
		return instance;
	}
	private Calcurator () {} // new 객체 생성 못하도록 생성자 private
	public int add(int a, int b) {
		return a+b;
	}
	

}
