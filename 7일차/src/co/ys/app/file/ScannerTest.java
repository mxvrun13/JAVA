package co.ys.app.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		// String str = "h 2";
		Scanner scanner = new Scanner(new FileInputStream("d:/temp/f.dat"));
		while(true) {
			try {
				String b = scanner.nextLine();
				System.out.println(b);
			} catch (Exception e) {
				break;
			}
		}
	}
}
