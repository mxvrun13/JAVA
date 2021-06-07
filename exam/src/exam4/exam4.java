package exam4;

public class exam4 {

	public static void main(String[] args) {
		
		String[] arr = {"010102-2","991012-1","960304-1","881012-2","040403-1"};
		// 		0보다 크면 1900 더하고, 0보다 작으면 2000 더함
		
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			String str = arr[i];
			int num = Integer.parseInt(str.substring(7));
			if(num==1) {
				cnt1+=1;
			} else if (num==2) {
				cnt2+=1;
			}
		}	
		System.out.println("남 " + cnt1 + "  여 " + cnt2);
		
		int now = 2021;
		int age = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			String str = arr[i];
			int num = Integer.parseInt(str.substring(0, 2));
			int first = Integer.parseInt(str.substring(0, 1));
			if (first>0) {
				num+=1900;
			} else {
				num+=2000;
			}
			age = now - num;
			if(age/10==1) {
				num1+=1;
			}else if(age/10==2) {
				num2+=1;
			}else if(age/10==3) {
				num3+=1;
			}else if(age/10==4) {
				num4+=1;
			}
		}
		System.out.println("10대 "+num1+"명");
		System.out.println("20대 "+num2+"명");
		System.out.println("30대 "+num3+"명");
		System.out.println("40대 "+num4+"명");
	
		
		
	}


}
