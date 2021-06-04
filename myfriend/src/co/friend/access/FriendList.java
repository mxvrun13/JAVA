package co.friend.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.friend.model.Friend;

public class FriendList implements FriendAccess {

	ArrayList<Friend> friends;	//List는 인터페이스 ArrayList는 클래스
	String path = "d:/temp/friend.txt";
	
	public FriendList() {	// 생성자
		friends = new ArrayList<Friend>();
		open();
		
	}

	
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (true) {
				String str = scanner.next();
				if(str==null) break;
				String[] arr = str.split(",");
				friends.add(new Friend(arr[0],arr[1],arr[2]));
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Friend f : friends) {
				fw.write(String.format("%s,%s,%s\n", f.getGubun(), f.getName(), f.getTel()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(Friend friend) {
		friends.add(friend);
		save();
		
	}

	@Override
	public void update(Friend friend) {		// 이름은 수정 불가, 전화번호만 변
		for (Friend f : friends) {
			if(f.getName().equals(friend.getName())) {
				f.setTel(friend.getTel());
				save();
			}
		}
	}

	@Override
	public void delete(String name) {
		for (Friend f : friends){
			if (f.getName().equals(name)) {
				friends.remove(f);
				save();
				break;
			}
		}
	}

	@Override
	public ArrayList<Friend> selectAll() {
		return friends;
	}

	@Override
	public Friend findName(String name) {
		for (Friend f : friends){
		if (f.getName().equals(name)) {
			return f;
			}
		}
		return null;
	}
	
	@Override
	public Friend findTel(String tel) {
		for (Friend f : friends){
		if (f.getTel().contains(tel)) {
			return f;
			}
		}
		return null;
	}

}
