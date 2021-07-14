package baekjoon;

import java.util.Scanner;

public class p1094 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int stick = 64;
		int compare = 0;
		int cnt = 0;
		while (true) {
			if(num==stick+compare) {
				cnt++;
				break;
			} else if (num>stick+compare){
				compare+=stick;
				cnt++;
			} else {
				stick=stick/2;
			}
		}
		System.out.println(cnt);
	}
}



