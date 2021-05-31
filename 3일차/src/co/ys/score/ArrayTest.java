package co.ys.score;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

		ArrayApp app = new ArrayApp();
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		int selectNo = 0;
		while(run) {
			System.out.println("1. 학생 수 2. 점수 입력 3. 점수 리스트 4. 븐석 5. 종료");
			System.out.println("선택 : ");
			selectNo = scanner.nextInt();
			if(selectNo == 1) {
				app.init();
			} else if (selectNo == 2) {
				app.input();
			} else if (selectNo == 3) {
				app.print();
			} else if (selectNo == 4) {
				app.avg();
				app.max();
			} else if (selectNo == 5) {
				System.out.println("프로그램을 종료합니다.");
				run = false;
			}
		}
	}

}
