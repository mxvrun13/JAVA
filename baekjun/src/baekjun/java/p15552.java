package baekjun.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class p15552 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(rd.readLine().trim());	// trim = 공백 없애기
		for (int i = 0 ; i < num ; i++) {
			String str = rd.readLine();
			String[] arr = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			wr.write(a+b + "\n");
		}
		wr.flush();
		wr.close();
	}

}
