package pkg.friend.util;

import java.util.Scanner;

import pkg.friend.Friend;

public class ScannerUtil {

	public static void main(String[] args) {
		
		readInt();
	}
		
		public static int readInt() {
			int result = 0;
			while (true) {
				try {
					Scanner scanner = new Scanner(System.in);
					System.out.println("입력 : ");
					result = scanner.nextInt();
					if(Character.isDigit(result))
						System.out.println(result);
						break;
				} catch (Exception e) {
					System.out.println("숫자를 입력하세요.");
			}
		}
			return result;
	}


		public static String readStr() {
			String result = "";
			while (true) {
				try {
					Scanner scanner = new Scanner(System.in);
					System.out.println("입력 : ");
					result = scanner.next();
						System.out.println(result);
						break;
				} catch (Exception e) {
					System.out.println("문자를 입력하세요.");
				}
			}
			return result;
		}
			

		public static String readDate() {
			String result;
				while(true) {
					try {
						Scanner scanner = new Scanner(System.in);
						System.out.println("입력 : ");
						result = scanner.next();
						String[] score = result.split("/");
						System.out.println("y : " + score[0] + ", m : " + score[1] + ", d : " + score[2]);
		
						if(result!=null) break;
					} catch (Exception e) {
						System.out.println("날짜를 입력하세요");;
					}
	
			}
				return result;
		}

			

		public static Friend readFriend() {		// 모르겠음
			Scanner scanner = new Scanner(System.in);
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

