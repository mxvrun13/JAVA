package 상속;

public class DmbCellPhoneTest {

	public static void main(String[] args) {
		DmbCellPhone phone = new DmbCellPhone();	// 부모 기본 생성자, 자식 기본 생성자 호출
		
		DmbCellPhone dmbCellPhone = new DmbCellPhone("삼성", "검정", 10);		// 부모 생성자, 자식 생성자 호출
		System.out.println(dmbCellPhone.model + " : " + dmbCellPhone.color);
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannel(20);
		dmbCellPhone.turnOffDmb();
		dmbCellPhone.powerOff();
	}
}
