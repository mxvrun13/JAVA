package pkg;

public class AppMain {
	
	static void print() {	// static으로 바꾸거나 main에서 클래스 생성하여 접근
		System.out.println("=====");
		printName();
	}
	public static void printName() {
		System.out.println("홍길동");
	}
	
	public static void main(String[] args) {
		
		Count count1 = new Count();
		Count.cnt1++;
		count1.cnt2++;
		Count count2 = new Count();
		Count.cnt1++;
		count2.cnt2++;
		Count count3 = new Count();
		Count.cnt1++;
		count3.cnt2++;
		// 스태틱은 공유 필드라 누적
		System.out.println(Count.cnt1 + " : " + count1.cnt2);
		System.out.println(Count.cnt1 + " : " + count2.cnt2);
		System.out.println(Count.cnt1 + " : " + count3.cnt2);
		
		print();
		
		System.out.println(ProjectInfo.name);	// static은 객체 생성 없이 클래스명으로 접근 가능
		ProjectInfo.uploadpath = "/upload";
		System.out.println(ProjectInfo.uploadpath);
		
		System.out.println(DateUtil.curDate());
		
		ProjectInfo info = new ProjectInfo();
		System.out.println(info.version);	// 인스턴스 필드느 객체 생성해야 접근 가능
	}

}
