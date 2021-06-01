package co.micol.tv;

public class SamsungTV implements RemoteControl {

	public void powerOn() {
		System.out.println("Samsung TV 전원 On");
	}

	public void powerOff() {
		System.out.println("Samsung TV 전원 Off");
	}

	public void volumeUp() {
		System.out.println("Samsung TV 볼륨 Up");
	}

	public void volumeDown() {
		System.out.println("Samsung TV 볼륨 Down");
	}

}
