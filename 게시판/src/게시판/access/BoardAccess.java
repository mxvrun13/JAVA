package 게시판.access;

import java.util.ArrayList;
import 게시판.model.Board;

public interface BoardAccess {
	
	public void insert(Board board);
	public void update(Board board);
	public void delete(String title);
	public ArrayList<Board> selectAll();
	public Board selectOne(String title);

}
