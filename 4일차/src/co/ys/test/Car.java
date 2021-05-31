package co.ys.test;

// 자동차 정보만 저장
public class Car {
	String company;
	String model;
	String color;
	int maxSpeed;
	int speed;
	
	// 생성자란 객체 생성 시 호출 되어 필드를 초기화 하는 특수 용도의 메서드, 생성자 이름은 클래스명과 동일, 리턴 타입 없음, 생성자 중복 선언은 가능하지만 매개변수의 타입과 갯수는 달라야 함 (오버 로딩)
	Car(String company, String model, String color) {
		this(company, model, color, 0, 0);
		
	}

	Car() {
		this("현대", "그랜저", "검정", 350, 0);
	}
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", speed=" + speed + "]";
	}

	public Car(String model, int speed) {
		this("", model, "", 0, speed);
		
	}

	public Car(String company, String model, String color, int maxSpeed, int speed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		if (maxSpeed > 100) {
			this.maxSpeed = maxSpeed;			
		} else {			
			this.maxSpeed = 100;
		}
		if (speed > 50) {
			this.speed = speed;
		} else {
			this.speed = 50;
		}
	}
	
}
