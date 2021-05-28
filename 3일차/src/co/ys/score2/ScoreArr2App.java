package co.ys.score2;

public class ScoreArr2App {
	int[][] arr = { { 100, 90, 80, 40 }, { 10, 20 }, { 50, 50, 50 }, { 30, 30, 30 } };

	void print() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
			System.out.println();
		}
	}

	// 입력한 번호의 학생의 총점 계산
	int stdTotal(int no) {
		int result = 0;
		for (int i = 0; i < arr[no].length; i++) {
			result += arr[no][i];
		}
		return result;
	}
	
	int getSubCnt(int no) {
		return arr[no].length;
	}
}
