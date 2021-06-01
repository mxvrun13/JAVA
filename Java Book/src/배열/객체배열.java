package 배열;

import java.awt.Point;

// 객체 배열 : 배열의 요소 타입이 객체인 경우

public class 객체배열 {
	public static void main(String[] args) {
		// 변수 선언
		Score[] a;
		a = new Score[10];
		a[0] = new Score("홍길동",100,90,80);
		a[1] = new Score("김기자",60,40,70);
		a[2] = new Score("이순신",80,90,60);
		
		// 이름만 출력
		for (int i =0 ; i < a.length ; i++) {
			if (a[i] !=  null) {				
				System.out.println(a[i].name);
			}
		}
		
		// 선언과 동시에 초기화
		Score[] b = {new Score("홍길동",100,90,80),
					 new Score("김기자",60,40,70),
					 new Score("이순신",80,90,60)};
		
		// 이름과 총점 출력
		for(Score score : b) {	// :b = 파이썬 in 배열변수			
			System.out.println(score.name + " : " + score.total);
		}
		
		
		// Point
		Point[] c = {new Point(10,10), 
					 new Point(30,10), 
					 new Point(10,30), 
					 new Point(30,30)};
		
		for (Point p : c) {				
				System.out.println(p.x + " : " + p.y);
		}
	}	
}
