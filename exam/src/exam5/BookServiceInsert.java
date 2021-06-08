package exam5;

import java.util.Scanner;

public class BookServiceInsert implements BookService{
	
	public BookServiceInsert() {}
	
	Scanner scanner = new Scanner(System.in);

	@Override
	public void execute(BookList list) {
		System.out.println("입력 > ");
		String result = scanner.nextLine();
		String[] arr = result.split(",");
		Book book = new Book();
		book.setIsbn(arr[0]);
		book.setName(arr[1]);
		book.setContent(arr[2]);
		list.insert(book);		// 매개 변수가 객체, 새로운 객체를 생성하여 담음
		
		
	}
}
