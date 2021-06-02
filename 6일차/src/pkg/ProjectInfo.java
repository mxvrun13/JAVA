package pkg;

/**
 * 
 * @author admin
 *
 */
		

public class ProjectInfo {
	public static final String name = "예담주식회사";	// 객체 생성 없이 접근 가능 (공유 필드), final - 초기값 이외에 변경 불가
	public static String uploadpath = "c:/temp";	// 스태틱 - 공유 필드, 변경 가능
	int version = 1;	// 인스턴스 필드
}
