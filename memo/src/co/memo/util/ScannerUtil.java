package co.memo.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.memo.model.Memo;

public class ScannerUtil {

		static Scanner scanner = new Scanner(System.in);
	
		
		public static int readInt(String prompt) {
			System.out.println(prompt+">");
			return readInt();
		}

		public static int readInt() {
			int result = 0;
			while (true) {
				try {
					String userInput = scanner.nextLine();
					result = Integer.parseInt(userInput);
						break;
				} catch (Exception e) {
					System.out.println("숫자를 입력하세요.");
			}
		}
			return result;
	}


		public static String readStr(String prompt) {
			System.out.println(prompt+">");
			return readStr();
		}
		
		public static String readStr() {
			String result = "";
			int i = 0;
			while (true) {
				try {
					result = scanner.next();
					i = Integer.valueOf(result);
					System.out.println("문자를 입력하세요.");
				} catch (Exception e) {
					System.out.println(result);
					break;
				}
			}
			return result;
		}
		
		public static String readEvery() {
			String result = "";
			result = scanner.nextLine();

			return result;
		}
		
		public static String readDate(String prompt) {
			System.out.println(prompt+">");
			return readDate();
		}
			
		public static String readDate() {
			String result;
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			do {
				try {
					result = scanner.next();
					df.parse(result.trim());
					break;
					} catch (Exception e) {
						System.out.println("(yyyyMMdd) 날짜를 입력하세요");;
					}
	
			} while (true);
				return result;
		}

		
		public static Memo readMemo() {
			System.out.println("입력 (yyyyMMdd,String) : ");
			String result = scanner.nextLine();
			String[] arr = result.split(",");
			Memo memo = new Memo();
			memo.setDate(arr[0]);
			memo.setContent(arr[1]);
			return memo;
		}
		
	}