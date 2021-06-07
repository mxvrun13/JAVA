package 연산자;

public class 비트연산 {

// ^ : XOR 연산, 서로 다르면 1
// & : and
// | : or
	
	public static void main(String[] args) {
		
		// 암호화, 복호화
		
		int a = 04474;
		int key = 01111;
		System.out.println("원문 : " + a);
		
		int b = a^key;
		System.out.println("암호화 : " + b);
		
		int c = b^key;
		System.out.println("복호하 : " + c);
	
		int d = 0b10101110;		//0b : 2진수
		int e = 0B00000001;		// 제일 마지막 숫자가 0인지 1인지 검사
		System.out.println("마지막 숫자는 " + Integer.toBinaryString(d&e));
		
		int f = 8;
		System.out.println(f>>1);	// 1000->0100
		System.out.println(f<<1);	// 1000->10000
	}

}
