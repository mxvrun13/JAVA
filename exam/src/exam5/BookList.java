package exam5;

import java.util.ArrayList;
import java.util.List;

public class BookList extends BookAccess{
	
	ArrayList<Book> books;
	
	public BookList() {
		books = new ArrayList<Book>();
	}

	@Override	// 중복 못함
	public void insert(Book book) {
		if (book.getName().equals() {
			System.err.println("이미 등록된 책 입니다.");
		} else {
			books.add(book);
		}

	}

	@Override
	public List<Book> findName(String name) {
		List<Book> list = new ArrayList<Book>();
		for (Book b : books) {
			if(b.getName().contains(name))
			list.add(b);
		}
		return list;
	}

}
