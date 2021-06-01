package co.micol.tv;

public class MainApp {

	// 명령행 인수
	public static void main(String[] args) {
		//SamsungTV tv = new SamsungTV();
		//LgTV tv = new LgTV();
		RemoteControl tv = (RemoteControl) BeanFactory.getBean(args[0]); 	// 다형성 : 부모 타입의 참조 변수가 자식 객체를 참조할 수 있다, 참조하는 대상의 메서드가 호출 (코드는 같아도 참조 대상에 따라 실행 결과가 다름)
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
	}
}
