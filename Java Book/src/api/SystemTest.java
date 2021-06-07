package api;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SystemTest {

	public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
		System.out.println(System.currentTimeMillis());
		// 파일명 rename, 실행시간 체크
		// System.exit(1);
		Map <String, String> map = System.getenv();
		System.out.println(map.get("JAVA_HOME"));
		Iterator<String> iter = map.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ":" + map.get(key));
			
		}
		// System.gc(); 가비지 컬렉터, 자동으로 실행됨
		Field[] fields = Book.class.getDeclaredFields();
		for (Field f : fields) {
			System.out.println(f.getName() + " : " + f.getType());
		}
		URI uri = Book.class.getResource("/resources23235423/menu.txt").toURI();	// 상대 경로
		Scanner scanner = new Scanner(new File(uri));
		System.out.println(scanner.next());
	}

}
