package baekjun.java;

import java.util.Scanner;

public class p2839 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("무게를 입력하시오. > ");
		int kg = sc.nextInt();
		int num1 = 5;
		int num2 = 3;
		int total5 = (kg/num1);
		int total3 = ((kg-(num1*total5))/num2);
		if (kg%num1 == 0 && (kg-(num1*total5))%num2 == 0) {
			System.out.println(total5+total3);
		} else {
			System.out.println(-1);
		}
		
	}

}
