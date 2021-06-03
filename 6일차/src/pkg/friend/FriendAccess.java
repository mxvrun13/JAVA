package pkg.friend;

// 메서드로만 구성되었다면 인터페이스
// 필드와 메서드로 구성되었다면 클래스
// 인터페이스 : 상수 필드 + 추상 메서드

// 친구 데이터를 개발 시 표준 선정
public interface FriendAccess {		// 모든 메서드는 public abstract 생략
	
	String model = "ㅇㅇ";	// 상수 필드 : public static final 생략
	
	// 등록, 수정, 삭제, 전체 조회, 단건 조회
	public void insert(Friend friend);
	public void update(String name);
	public void delete(String name);
	public void selectAll();
	public Friend selectOne(String name);
	
	
	
	
}