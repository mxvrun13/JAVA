package co.yedam.app.gugudan;

public class GugudanApp {

	void printDan(int dan) {	// dan단 출력
		for(int i=dan ; i<dan+1 ; i++) {
			for(int j=1 ; j<10 ; j++) {
				System.out.print(i + " * " + j + " = " + i*j + "\t");
			}
		}
	}
	void printRange(int s, int e) {		//s단에서 e단까지 출력
		for(int i=s ; i<e+1 ; i++) {
			for(int j=1 ; j<10 ; j++) {
				System.out.print(i + " * " + j + " = " + i*j + "\t");
			}
		}
	}
			
	void printAll() {		// 9단까지 모두 출력
		for(int i=1 ; i<10 ; i++) {
			System.out.println();
			for(int j=1 ; j<10 ; j++) {
				System.out.print(j + " * " + i + " = " + j*i + "\t");
			}
		}
	}
	void printAllReverse() {		// 9단부터 거꾸로 출력
		for(int i=9 ; i>0 ; i--) {
			for(int j=1 ; j<10 ; j++) {
				System.out.print(i + " * " + j + " = " + i*j + "\t");
			}
		}
	}
}	
