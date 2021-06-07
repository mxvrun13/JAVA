package exam5;

import java.util.List;

public abstract class BookAccess {
	
	public abstract void insert(Book book);
	public abstract List<Book> findName(String content);
	
}
