package co.ys.score;

public class ArrayApp {
	int[] arr = new int[10];

	void init() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 100) + 1;
		}
	}

	void print() {
		// 배열 출력
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	void total() {
		// 합계
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		System.out.println("합계 = " + result);
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
		app.total();
		app.max();
		app.print();

	}

}
