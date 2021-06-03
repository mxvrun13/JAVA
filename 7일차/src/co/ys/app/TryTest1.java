package co.ys.app;

import java.util.Scanner;

public class TryTest1 {

	public static void main(String[] args) {
		
		try {
			String s = null;
			System.out.println(s.charAt(0));	//NullPointer
		} catch(Exception e) {
			 System.out.println(e.getMessage());
		}
		
		try {
			int[] arr = new int[5];
			System.out.println(arr[5]);		//ArrayIndexOutOf
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int a = 0;
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("입력 > ");
				a = scanner.nextInt();
				if(a<5)
					break;
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("a : " + a);
		System.out.println("The End");
	}
}
