package 열거타입;

public enum Menu {
	등록(1), 수정(2), 삭제(3), 조회(4), 종료(0);

	private int value ;
	public int getValue() {
		return value;
	}
	
	private Menu(int value) {
		this.value = value;
	}
	
	public static void print() {
		Menu[] arr = Menu.values();
		for(Menu m : arr) {
			System.out.println(m.value + " : " + m);
		}
	}
	
	public static Menu getMenu (int v) {
		Menu[] arr = Menu.values();
		for(Menu m : arr) {
			if(m.getValue() == v) {
				return m;
			}
		}
		return null;
	}
}
