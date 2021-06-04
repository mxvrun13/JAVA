package co.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.memo.model.Memo;

public class MemoList implements MemoAccess {
	
	ArrayList<Memo> memo;
	String path = "d:/temp/memo.txt";
	
	public MemoList() {
		memo = new ArrayList<Memo>();
		open();
	}
	
	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (true) {
				String str = scanner.next();
				if(str==null) break;
				String[] arr = str.split(",");
				memo.add(new Memo(arr[0],arr[1]));
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Memo m : memo) {
				fw.write(String.format("%s,%s\n", m.getDate(), m.getContent()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(Memo write) {
		memo.add(write);
		save();
		
	}

	@Override
	public void update(Memo write) {		// 이름은 수정 불가, 전화번호만 변
		for (Memo m : memo) {
			if(m.getDate().equals(write.getDate())) {
				m.setContent(write.getContent());
				save();
			}
		}
	}

	@Override
	public void delete(String write) {
		for (Memo m : memo){
			if (m.getDate().equals(write)) {
				memo.remove(m);
				save();
				break;
			}
		}
	}

	@Override
	public ArrayList<Memo> selectAll() {
		return memo;
	}

	@Override
	public Memo findDate(String date) {
		for (Memo m : memo){
		if (m.getDate().equals(date)) {
			return m;
			}
		}
		return null;
	}
	
	@Override
	public Memo findContent(String content) {
		for (Memo m : memo){
		if (m.getContent().contains(content)) {
			return m;
			}
		}
		return null;
	}

}
