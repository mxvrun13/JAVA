package baekjun.java;

import java.util.Scanner;

public class p2753 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("연도 입력 > ");
		int year = scanner.nextInt();
		
		if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
