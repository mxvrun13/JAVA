package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class p1931 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int [][] arr = new int[num][2];
		
		for (int i = 0 ; i < num ; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
            	return start[0]-end[0];
            }
        });
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] start, int[] end) {
            	return start[1]-end[1];
            }
        });
		
		int cnt = 0;
		int end_time = 0;
		
		for(int i = 0 ; i<num ; i++) {
			if(arr[i][0]>=end_time) {
				end_time = arr[i][1];
				cnt++;
			}
		}
	System.out.println(cnt);
	}
	

}
