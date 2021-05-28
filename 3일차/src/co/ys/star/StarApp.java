package co.ys.star;

public class StarApp {

	// 삼각형 출력
	void draw(int a) {
		for(int i=1 ; i<=a ; i++) {
			System.out.println(pad('*',i));

		}
	}
	
	// 역삼각형 츨력
	void drawInvert(int b) {
		for(int i=b ; i>0 ; i--) {
			System.out.println(pad('*',i));
		}
	}
	
	// 이등변 삼각형 출력
	void drawEq(int cnt) {
		for(int i=1 ; i<cnt ; i++) {			
			System.out.print(pad(' ',50)+pad(' ',cnt-i));
			System.out.println(pad('*', i*2-1));
		}
	}
	
	//이등변 역삼각형 출력
	void drawEqInvert(int cnt) {
		for(int i=cnt ; i>0 ; i--) {			
			System.out.print(pad(' ',cnt-i));
			System.out.println(pad('*', i*2-1));
		}
	}
	
	// 트리 모양
	void drawEq(int n1, int n2) {
		for(int i=n1 ; i<n2 ; i++) {			
			System.out.print(pad(' ',50)+pad(' ',n2-i));
			System.out.println(pad('*', i*2-1));
		}
	}
			
	// (*,10) = * 10개 생성
	String pad(char s, int cnt) {
		String result = "";
		for(int i=0 ; i<cnt ; i++) {
			result += s;
		}
		return result;
	}
}