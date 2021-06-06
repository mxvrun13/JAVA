package baekjun.java;

import java.util.Scanner;

public class p2577copy {

	public static void main(String[] args) {	// 어렵..
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int total = num1*num2*num3;
		String str = Integer.toString(total);
		String[] arr = str.split("");

		for (int i=1 ; i<10 ; i++) {
			int cnt = 0;			
			for (int j=0;j<arr.length;j++) {
				i = Integer.parseInt(arr[j]);
				cnt+=1;
			}
			System.out.println(cnt);
		}
		
	}
}
