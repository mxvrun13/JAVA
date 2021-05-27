package co.yedam.app.score;

// 성적 처리 프로그램 (국어, 영어, 수학 점수를 입력 받아 총점, 평균, 등급 계산)

import java.util.Scanner;

public class ScoreApp {

	int kor;
	int eng;
	int mat;
	int sum;
	double avg;
	char grade;
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("국어 : ");
		kor = scanner.nextInt();
		System.out.println("영어 : ");
		eng = scanner.nextInt();
		System.out.println("수학 : ");
		mat = scanner.nextInt();
		scanner.close();
		sum = kor + eng + mat;
		avg =  (double)sum / 3;
	}
	int getSum() {
		return sum;
	}	
	double getAvg() {
		return avg;
	}
	boolean isPass( ) {
		if(avg > 60) {
			return true;
		} else {
			return false;
		}
	}
	char getGrade() {
		switch((int)avg/10) {
		case 10:
		case 9:
		case 8:
			grade = '상';
			break;
		case 7:
		case 6:
			grade = '중';
			break;
		default:
			grade = '하';
			break;
		}
		return grade;
	}
}
