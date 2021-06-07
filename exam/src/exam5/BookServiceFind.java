package exam5;

import java.util.List;
import java.util.Scanner;

public class BookServiceFind implements BookService{
	

	
	public BookServiceFind() {}

	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void execute(BookList list) {
		System.out.println("입력 > ");
		String name = scanner.next();
		List<Book> list2 = list.findName(name);
		for (Book b : list2) {
			System.out.println(b);		
		
		}
		
	}

}
