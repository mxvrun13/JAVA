package 게시판.access;

import java.util.ArrayList;

import 게시판.model.Board;

public class BoardList implements BoardAccess{
	
	ArrayList<Board> board;
	
	public BoardList() {
		board = new ArrayList<Board>();
	}

	@Override
	public void insert(Board insert) {
		board.add(insert);
		
	}

	@Override
	public void update(Board update) {
		for(Board b : board) {
			if(b.getTitle().equals(update.getTitle())) {
				b.setContent(update.getContent());
			}
		}
	}

	@Override
	public void delete(String title) {
		for(Board b : board) {
			if(b.getTitle().equals(title)) {
				board.remove(b);
				break;
			}
		}
		
	}

	@Override
	public ArrayList<Board> selectAll() {
		return board;
	}

	@Override
	public Board selectOne(String title) {
		for(Board b : board) {
			if(b.getTitle().equals(title));
			return b;
		}
		return null;
	}

}
