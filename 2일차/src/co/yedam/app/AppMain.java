package co.yedam.app;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		CalcGame game = new CalcGame();
		
		System.out.println(game.sum(10));
		System.out.println(game.sum(100));
		//game.input();
		
		//System.out.println("덧셈 " + game.add());
		//System.out.println("몫 " + game.share());
		//System.out.println("나누기 " + game.div());
		//System.out.println("나머지 " + game.rest());
	}

}
