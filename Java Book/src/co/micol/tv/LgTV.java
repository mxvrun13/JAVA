package co.micol.tv;

public class LgTV implements RemoteControl {

	public void powerOn() {
		System.out.println("LG TV 전원 On");
	}

	public void powerOff() {
		System.out.println("LG TV 전원 Off");
	}

	public void volumeUp() {
		System.out.println("LG TV 볼륨 Up");
	}

	public void volumeDown() {
		System.out.println("LG TV 볼륨 Down");
	}

}
