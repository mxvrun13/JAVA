package co.reserve.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ScannerUtil {

	static Scanner scanner = new Scanner(System.in);
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String TIME_FORMAT = "HH:mm";

	public static int readInt() {
		int result = 0;
		while (true) {
			try {
				String userInput = scanner.nextLine();
				result = Integer.parseInt(userInput);
				break;
			} catch (Exception e) {
				System.err.println("숫자를 입력하세요.");
				System.out.println("입력 > ");
			}
		}
		return result;
	}

	public static String readStr() {
		String result = "";
		int i = 0;
		while (true) {
			try {
				result = scanner.next();
				i = Integer.valueOf(result);
				System.err.println("문자를 입력하세요.");
				System.out.println("입력 > ");
			} catch (Exception e) {
				System.out.println(result);
				break;
			}
		}
		return result;
	}

	public static String readDate() {
		String date = null;
		while (true) {
			System.out.println("날짜(yyyy-mm-dd) > ");
			date = scanner.next();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				sdf.parse(date);
				if (date != null)
					break;
			} catch (ParseException e) {
				System.err.println("올바르지 않은 입력입니다. ex) yyyy-mm-dd");
			}
		}
		return date;
	}

}