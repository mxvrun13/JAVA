package pkg.other;

import pkg.Car;
import pkg.Count;
import pkg.DateUtil;
import pkg.ProjectInfo;
// private > default > protected > public
// 클래스 내부  같은 패키지  다른 패키지 (상속)

public class AppMain {
	
	public static void main(String[] args) {
		
		Car car = new Car();	// Car()는 생성자
		car.setModel("현대");
		car.setSpeed(100);
		
		Car car2 = new Car("삼성",100);
		Car car3 = new Car("삼성");
		System.out.println(car2.getModel() + " : " + car2.getSpeed());
		System.out.println(car3.getModel() + " : " + car3.getSpeed());
		
		System.out.println(DateUtil.curDate());
		System.out.println(ProjectInfo.name);
		
		Count count1 = new Count();
		Count.cnt1++;
		count1.setCnt (count1.getCnt2() + 1);
	}

}
