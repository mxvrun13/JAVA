package co.ys.numgame;

import java.util.Scanner;

public class NumberGameApp {
	
	// 임의의 수
	int com;  //난수
	int user; // 사용자 수 입력
	
	void init() {
		com = (int) (Math.random() * 10) + 1; //컴퓨터가 만든 수(1~10)
	}
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 : ");
		user = scanner.nextInt();
	}
	
	// 높다/낮다/정답 출력
	boolean confirm() {
		boolean result = false;
		if (com > user || com < user) {
			System.out.println("틀렸습니다.");
			result = false;
		} else {
			System.out.println("맞았습니다.");
			result = true;
		}
		return result;
	}
	void start() {
		init();
		while(true) {
			input();
			if(confirm()) {
				break;
			}
		}
	}
}
