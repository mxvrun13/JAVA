package baekjun.java;

import java.util.Scanner;

public class p2577 {

	public static void main(String[] args) {	// 어렵..
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int total = num1*num2*num3;
		String str = Integer.toString(total);
		int [] number = new int[10];

		while (total > 0) {
			number[total%10]++;
			total/=10;
		}
		
		for (int i=0 ; i<number.length ; i++) {
			System.out.println(number[i]);
		}
	}
}
