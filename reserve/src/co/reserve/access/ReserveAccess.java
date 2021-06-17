package co.reserve.access;

import java.util.ArrayList;

import co.reserve.model.Member;
import co.reserve.model.Reserve;

public interface ReserveAccess {
	
	public ArrayList<Reserve> adminSelectAll();
	public ArrayList<Reserve> adminSelectDate(String date);
	public ArrayList<Member> adminMemberSelect();
	public void adminDelete(String id, String date);
	public ArrayList<Reserve> selectAll(String id);
	public void insert(Reserve reserve);
	public void delete(String id, String date);
	
}
