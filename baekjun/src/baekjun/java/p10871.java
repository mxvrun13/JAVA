package baekjun.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p10871 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String[] arr = str.split(" ");
		int num1 = Integer.parseInt(arr[0]);
		int num2 = Integer.parseInt(arr[1]);
		
		String input = br.readLine();
		String[] inputarr = input.split(" ");

		for (int i = 0 ; i < num1 ; i++) {
			if(Integer.parseInt(inputarr[i]) < num2) {
				bw.write(inputarr[i] + " ");
			}
		}
		bw.flush();
		bw.close();
	}

}
