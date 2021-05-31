package co.ys.test;

public class CarExample {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		myCar.company = "삼성 자동차";
		myCar.maxSpeed = 400;
		myCar.color = "레드";
		
		System.out.println("제작 회사 : " + myCar.company);
		System.out.println("모델명 : " + myCar.model);
		System.out.println("색깔 : " + myCar.color);
		System.out.println("최고 속도 : " + myCar.maxSpeed);
		System.out.println("스피드 : " + myCar.speed);
				
		myCar.speed = 60;
		System.out.println("수정된 속도 : " +  myCar.speed);
		
		// 생성자
		Car youCar = new Car("르노", "SM6", "블루");
		System.out.println(youCar.toString());
		
		// 코나 100
		Car miniCar = new Car("코나", 40);
		System.out.println(miniCar);
	}

}
