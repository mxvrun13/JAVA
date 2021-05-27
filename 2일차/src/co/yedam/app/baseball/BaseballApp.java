package co.yedam.app.baseball;

import java.util.Scanner;

// 임의의 수 3개, 사용자 수 입력, 스트라이크와 볼 카운터

public class BaseballApp {
	int s;
	int b;
	int c1, c2, c3;
	int u1, u2, u3;
	 
	
	void makeRnd() {
		c1 = (int) Math.floor(Math.random()*10);
		c2 = (int) Math.floor(Math.random()*10);
		c3 = (int) Math.floor(Math.random()*10);
	}
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력 : ");
		u1 = scanner.nextInt();
		System.out.println("입력 : ");
		u2 = scanner.nextInt();
		System.out.println("입력 : ");
		u3 = scanner.nextInt();
		scanner.close();
	}
	void count( ) {
		if (c1 = u1) {
			s+=1
		}
	    elif c1 == u2 or c1 == u3 :
	        b+=1

	    if c2 == u2:
	        s+=1
	    elif c2 == u1 or c2 == u3:
	        b+=1

	    if c3 == u3:
	        s+=1
	    elif  c3 == u1 or c3 == u2:
	        b+=1
	}
	void start() {
		makeRnd();
		while(s<3) {
			s = b = 0;
			input();
			count();
		}
	}
}
