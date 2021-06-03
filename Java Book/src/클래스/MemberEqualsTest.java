package 클래스;

public class MemberEqualsTest {

	public static void main(String[] args) {
		
		Member m1 = new Member("박기자","park","1111",20);
		Member m2 = new Member(new String("박기자"),"park","2222",25);
		System.out.println(m1==m2);
		System.out.println(m1.equals(m2));

	}
}
