package baekjun.java;

import java.util.Scanner;

public class p4344 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = 0;	// 인원 수
		double avg = 0;		// 평균
		
		System.out.println("횟수 입력 > ");
		int cnt = sc.nextInt();

		int total = 0;
		
		for (int i=0;i<cnt;i++) {
			System.out.println("인원 수와 점수 입력 > ");
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			System.out.println(arr[0]);
			num = Integer.parseInt(arr[0]);
			for (int j=1;j<num;j++) {
				total += Integer.parseInt(arr[j]);
			}
		double db = total/num;
		System.out.println(db);
			
		}
	}
}

	

