package baekjun.java;

import java.util.Scanner;

public class p11720 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("갯수 입력 > ");
		int num = scanner.nextInt();
		System.out.println("숫자 입력 > ");
		String str = scanner.nextLine();
		String[] arr = new String[num];		
		for (int i=0;i<num;i++) {
			arr[i] = str.substring(i,i+1);
		}
		System.out.println(arr[0]);
	}

}
