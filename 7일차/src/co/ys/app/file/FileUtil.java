package co.ys.app.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {

	public static void copy(String src, String des) {
		
		// 파일 복사
		try {
			FileInputStream fis = new FileInputStream(src);		// 예외 처리 필수
			FileOutputStream fos = new FileOutputStream(des);
			byte[] b = new byte[100];
			while (fis.read(b) != -1) {
				fos.write(b);
			}
			fis.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
