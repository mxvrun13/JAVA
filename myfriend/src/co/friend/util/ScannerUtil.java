package co.friend.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import co.friend.model.Friend;

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
					String userInput = scanner.next();
					result = Integer.parseInt(userInput);
//					if(Character.isDigit(result))		// nextInt일 땐 없어도 됨, next일 때 사용
//						System.out.println(result);
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
//					if(result )
//						System.out.println(result);
				} catch (Exception e) {
					System.out.println(result);
					break;
				}
			}
			return result;
		}
		
		public static String readEvery() {
			String result = "";
			result = scanner.next();

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
//					String[] score = result.split("/");
//					System.out.println("y : " + score[0] + ", m : " + score[1] + ", d : " + score[2]);
//		
//						if(result!=null) break;
					} catch (Exception e) {
						System.out.println("(yyyyMMdd) 날짜를 입력하세요");;
					}
	
			} while (true);
				return result;
		}

		
		public static Friend readFriend() {		// 모르겠음
			System.out.println("입력(,) : ");
			String result = scanner.next();	// 초등 홍길동 1111 입력
			String[] arr = result.split(",");
			Friend friend = new Friend();
			friend.setGubun(arr[0]);
			friend.setName(arr[1]);
			friend.setTel(arr[2]);
			return friend;
		}
		
	}

