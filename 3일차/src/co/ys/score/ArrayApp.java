package co.ys.score;

import java.util.Scanner;

public class ArrayApp {
	int[] arr;		// 성적 저장
	int studentNum;		// 학생 수 저장
	Scanner scanner = new Scanner(System.in);
	
	void init() {
		System.out.println("인원 수 : ");
		studentNum = scanner.nextInt();
		arr = new int[studentNum];
;	}

	void input() {
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("score[%d]", i);
			arr[i] = scanner.nextInt();
		}
	}

	void print() {
		// 배열 출력
		for (int j = 0; j < arr.length; j++) {
			System.out.printf("score[%d] %d\n", j, arr[j]);
		}
		System.out.println();
	}

	void avg() {
		// 합계
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		System.out.println("평균 = " + (result/arr.length));
	}

	void max() {
		// 최대값
		int num = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (num < arr[i]) {
				num = arr[i];
			}
		}
		System.out.println("최댓값 = " + num);
	}


	public static void main(String[] args) {

		ArrayApp app = new ArrayApp();
		app.init();
		app.avg();
		app.max();
		app.print();

	}

}
