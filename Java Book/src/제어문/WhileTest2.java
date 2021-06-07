package 제어문;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		int a = 0 ;
		
		Scanner sc = new Scanner(System.in);
		
		do {	// 한 번은 실행하고 조건 비교
			a = sc.nextInt();
			System.out.println(a);
		} while (a!=0);
		System.out.println("end");
	}

}
