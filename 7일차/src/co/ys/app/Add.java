package co.ys.app;

public class Add {

	public static void main(String[] args) {
		
		String data1 = null;
		String data2 = null;
		try {
			data1 = args[0];
			data2 = args[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			System.out.println(value1 / value2);
		} catch(NumberFormatException e) {		// 다중 캐치, 해당 에러로 자동 점프
			System.out.println("숫자를 입력해주세요.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("숫자를 2개 넣어주세요.");
			//return;		// 숫자 하나만 입력 시 "숫자 입력"까지 뜨지 않게 하기 위해서
		}  catch(Exception e) {		// 위의 2개를 제외한 모든 예외처리 담당, 맨 밑에 있어야 함
			System.out.println(e.getMessage());
		}
		
	}

}
