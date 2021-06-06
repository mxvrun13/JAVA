package baekjun.java;

import java.util.Scanner;

public class p11718 {	// stream?
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		while (scn.hasNextLine()) {
			String str = scn.nextLine();
			if (str.startsWith(" ") == false && str.endsWith(" ") && str.length()<=100 && str.isEmpty() == false) {
				System.out.println(str);
			} else {
				break;
			}
		}
		scn.close();
	}
}
