package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.BitSet;
import java.util.StringTokenizer;

public class p13701 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BitSet bs = new BitSet();
		while(st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if(bs.get(num)) continue;
			bs.set(num);
			bw.write(num+" ");
		}
//		for (int i = 0; i < arr.length; i++) {
//			list[i] = Integer.parseInt(arr[i]);
//			for (int j = 0; j < list.length; j++) {
//				if (list[i] == list[j]) {
//					list[i]=list[i+1];
//				} 
//			System.out.println(list[i]);	
//			}
//		}
		bw.flush();
	}

}
