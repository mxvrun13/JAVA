package co.board.access;

import java.util.ArrayList;

import co.board.model.Board;

public interface BoardAccess {
	
	public ArrayList<Board> selectAll();
	public void insert(Board board);
	public void update(Board board);
	public void delete(int id);
	public Board selectOne(int id);
	
}
