package baekjun.java;

import java.util.Calendar;
import java.util.Scanner;

public class p2884 {

	public static void main(String[] args) {

//		Calendar calendar = Calendar.getInstance();
//		int hour = calendar.get(Calendar.HOUR);
//		int minute = calendar.get(Calendar.MINUTE);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("시간을 입력하세요. >");
		String time = scanner.nextLine();
		String[] arr = time.split(" ");
		int h = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int set = 45;
		if (m>set) {
			System.out.println(h+" "+(m-set));
		} else {
			if (h-1<0) {
				h=23;
				System.out.println(h+" "+(m+(60-set)));
			} else {
			System.out.println((h-1)+" "+(m+(60-set)));	
			}
		}
	}
}


