package co.friend.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import co.friend.model.Friend;

public class CollectionEx3 {

	public static void main(String[] args) {
		Map<String,Friend> map = new HashMap<> ();
		map.put("반장", new Friend("1반","이이삭","1111"));
		map.put("학우", new Friend("1반","김민수", "2222"));
		map.put("선생님", new Friend("1반","정광용", "3333"));
		map.put("반장", new Friend("1반","이용주", "1111"));
		
		System.out.println(map.get("선생님"));	// get으로 인덱스값으 가져오는 건 리스트, 키값을 가져오는 건 맵
		
		Set<String> keys = map.keySet();	// 키 값을 set 컬렉션에 담음
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Friend val = map.get(key);
			System.out.println("key : " + key + ", value : " + val);
		}
		
		// Friend값이 key, int가 val
		Map<Friend, Integer> scores = new HashMap<>();
		scores.put(new Friend("1반","김민수","1111"), 80);
		scores.put(new Friend("1반","이이삭","1111"), 90);
		scores.put(new Friend("1반","정광용","1111"), 85);
		scores.put(new Friend("1반","김영서","1111"), 91);
		
		Set<Entry<Friend,Integer>> ent = scores.entrySet();	// 키와 값을 쌍으로 set에 담음
		Iterator<Entry<Friend,Integer>> eiter = ent.iterator();
		while(eiter.hasNext()) {
			Entry<Friend,Integer> e = eiter.next();
			System.out.println(e.getKey()+", "+e.getValue());
		}
	}

}
