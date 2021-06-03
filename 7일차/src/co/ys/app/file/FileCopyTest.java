package co.ys.app.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTest {

	public static void main(String[] args) {
		
		// 파일 복사
		try {
			FileInputStream fis = new FileInputStream("d:/temp/image.png");		// 예외 처리 필수
			FileOutputStream fos = new FileOutputStream("d:/temp/image2.png");
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
