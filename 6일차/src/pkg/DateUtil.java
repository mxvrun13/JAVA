package pkg;

// 정적 메서드 안에서는 정적 필드만 접근 가능
public class DateUtil {
	
//	String date = "20210610";
//	static String curDate() {	// 스태틱 메서드에서 인스턴스 필드 접근 불가
//		DateUtil dateUtil = new DateUtil();	// 객체 생성해야 인스턴스 필드 접근 가능
//		return dateUtil.date;
	
	public static String curDate() {
		return "20210610";
	}

}
