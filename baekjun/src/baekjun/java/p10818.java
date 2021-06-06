package baekjun.java;

import java.util.Scanner;

public class p10818 {

	public static void main(String[] args) {
		
		 Scanner scanner = new Scanner(System.in);
	      System.out.println("갯수 입력 > ");
	      int cnt = scanner.nextInt();
	      int[] arr = new int[cnt];
	      int max = -1000000;
	      int min = 1000000;
	      
	      for (int i=0 ; i<cnt ; i++) {
	    	  arr[i] = scanner.nextInt();	    	  
	    	  if (max < arr[i]) {
	    		  max = arr[i];
	    	  } else if (min > arr[i]) {
	    		  min = arr[i];
	    	  }
	      }
	      System.out.println(max + " " + min);
	}

}
