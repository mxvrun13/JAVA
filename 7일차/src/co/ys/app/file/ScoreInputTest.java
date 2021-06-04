package co.ys.app.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class ScoreInputTest {

	public static void main(String[] args) {
		
		try {
			BufferedReader fr = new BufferedReader(new FileReader("d:/temp/score.txt"));
			PrintStream out = System.out;
			String a;
			while(true) {
				a = fr.readLine();
				String[] score = a.split(" ");
				int total = 0;
				for(int i = 0 ; i<score.length ; i++) {
					int num = Integer.parseInt(score[i]);
					total += num;
				} 
				System.out.println(total);
				
				if(a==null) break;
				out.println(a);
			}
			fr.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());;
		}
	}

}
