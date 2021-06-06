package baekjun.java;

import java.util.Scanner;

public class p1330 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 두 개 입력 > ");
		String str = scanner.nextLine();
		String[] arr = str.split(" ");
		
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[1]);
		
		if (num1 < num2) {
			System.out.println("<");
		} else if (num1 > num2) {
			System.out.println(">");
		} else {
			System.out.println("==");
		}
	}

}
