package 상속;

public class DmbCellPhone extends CellPhone{
	
	int channel;
	
	public DmbCellPhone() {
		// super(); : 부모 기본 생성자 호출, 생략됨
		System.out.println("DmbCellPhone 기본 생성자");	// 부모 생성자 호출 후 자식 생성자 호출
	}
	public DmbCellPhone (String model, String color, int channel) {
		super(model, color);	// 매개 변수가 있는 생성자 호출, 부모 먼저 호출해야 에러 x
		this.channel = channel;
		System.out.println("DmbCellPhone 생성자");
	}
	
	void turnOnDmb() {
		System.out.println("채널 " + channel + "번 DMB 방송 수신 시작");
	}
	void turnOffDmb() {
		System.out.println("DMB 방송 수신 종료");
	}
	void changeChannel(int channel) {
		this.channel = channel;
		System.out.println("채널을 " + channel + "(으)로 변경");
	}
	
	@Override // 재정의 : 상속 받은 메서드를 수정하여 사용 (오버로딩 : 중복 정의)
	void powerOn() {
		//super.powerOn();
		System.out.println("DMB 전원 On");
	}
	
}
