package 배열;

// 배열은 크기 고정, 순차적으로 데이터를 저장하고 읽는 용도, 추가 및 삭제가 번거로움

public class 배열초기화 {
	public static void main(String[] args) {
		
		// 1차원 배열
		int[] a; // 배열도 객체로 선언 -> new로 힙 메모리에 할당 
		a = new int[10]; // 배열 선언 (크기 지정)
		// 배열값 초기화
		a[0] = 10;
		a[1] = 20;
		a[2] = 100;
		a[3] = 50;
		
		// 삭제 (인덱스 다음부터 앞으로 이동)
		for (int i = 2 ; i<a.length ; i++) {
			a[i-1] = a[i];
		}
		// 배열 출력
		for (int i = 0 ; i<a.length ; i++) {
			System.out.println(a[i]);
		}
		
		// 배열 선언과 초기화를 한번에
		int[] b = {10,20,30};	// new int[3] -> {10,20,30}
		System.out.println("배열 크기는 " + b.length);
				
	}
}