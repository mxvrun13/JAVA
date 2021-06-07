package baekjun.java;

import java.util.Scanner;

public class p4344copy {

public static void main(String args[])  {
		
		int person = 0;  //몇명의 학생의 성적을 입력 받을지 수를 입력
		int grade = 0; //학생들의 성적의 합
		int loop =0; //첫번째 입력 받은 수를 그 수만큼 실행하기 위해 사용
		float pa = 0; // pa = person average
		float result = 0;
		
		Scanner sc = new Scanner(System.in);
		
		int cnt = sc.nextInt();
		
		for(int i =0; i< cnt; ++i) {
		String line2 = sc.nextLine();
		String[] sp = line2.split(" ");
		
		float cnt2 = Integer.parseInt(sp[0]);
		
			for(int j=0; j<cnt2+1; j++) {
				if(j==0) {
					person = Integer.parseInt(sp[j]);
				}else if(j<=cnt2+1){
					grade = grade +Integer.parseInt(sp[j]);
				}
		
			}
			
		float a = grade/cnt2;
		
	
			for(int j=0; j<cnt2+1; j++) {
				if(j==0) {
				}else if(j<=cnt2+1) {
					if(Integer.parseInt(sp[j])>a) {
						pa = pa+1;
					}
				}
			}
	
		result = (pa/cnt2)*100;
	
		System.out.printf("%.3f",result);
		System.out.println("%");
		grade=0;
		pa=0;
	
		}
		sc.close();
	}
}
