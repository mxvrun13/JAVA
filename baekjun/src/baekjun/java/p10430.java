package baekjun.java;

import java.util.Scanner;

public class p10430 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자 3개 입력 > ");
		String str = scanner.nextLine();
		String[] arr = str.split(" ");
		
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[1]);
		int num3 = Integer.parseInt(arr[2]);
		
		System.out.println(((num1+num2)%num3));
		System.out.println((((num1%num2)+(num2%num3))%num3));
		System.out.println(((num1*num2)%num3));
		System.out.println((((num1%num2)*(num2%num3))%num3));

		
		
				

	}

}
