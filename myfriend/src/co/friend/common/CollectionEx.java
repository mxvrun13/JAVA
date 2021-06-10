package co.friend.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CollectionEx {

	public static void main(String[] args) {
		List<String> list = null;
		list = new ArrayList<String>();
		list.add("hong");
		list.add("park");
		list.add("Choi");
		
		list.remove(0);
		
		for (int i=0 ; i<list.size() ; i++) {
			System.out.println(list.get(i));
		}
		Set<String> set = new HashSet<>();
		set.add("hong");
		set.add("Park");
		set.add("Choi");
		set.add("hong");	// 중복 값은 제외
		
		System.out.println("<set>");
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String value = iter.next();
			
			System.out.println(value);
		}
		
//		for(int i=0;i<set.size();i++) {
//			System.out.println(set);
//		}
		
	}

}
