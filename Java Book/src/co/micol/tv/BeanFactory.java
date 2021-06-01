package co.micol.tv;

public class BeanFactory {
	
	// Object : 최상위 클래스
	public static Object getBean(String beanName) {
		if (beanName.equals("samsung")) {
			return new SamsungTV();
		} else if (beanName.equals("lg")) {
			return new LgTV();
		}
		return null;
	}
}
