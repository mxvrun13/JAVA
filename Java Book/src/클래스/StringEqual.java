package 클래스;

public class StringEqual {

	public static void main(String[] args) {
		String s1 = "hello";	// 상수를 따로 저장하는 공간 존재, new가 아닌건 전부 상수 영역 저장
		String s2 = "hello";
		
		String s3 = new String("hello");
		String s4 = new String("hello");
	
		System.out.println(s1==s2);		// 몬자열 상수 비교
		System.out.println(s3==s4);		// 주소 비교, 별개의 다른 객체
		System.out.println(s1==s3);		
		System.out.println(s1.equals(s3));	
		System.out.println(s3.equals(s4));
	
		StringBuffer sb = new StringBuffer("hello world");
		sb.insert(5, "!!");
		System.out.println(sb.toString());
		sb.replace(0, 5, "hi");
		System.out.println(sb.toString());
	}

}
