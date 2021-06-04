package co.ys.app.file;

import java.io.File;
import java.io.IOException;

public class FileTest {
	
	public static void filecreate() throws IOException {
		
		// 파일 생성
		File file = new File("d:/temp/diary.txt");
		boolean result = file.createNewFile();
		System.out.println(result);		// 두번 실행하면 이미 파일이 만들어져서 false
		
	}
	
	public static void main(String[] args)  {
		
		// filecreate();
		// makefolder();
		// fileInfo();
		folderList();
	}

	private static void folderList() {
		
		File file = new File("d:/temp");
		if (file .isDirectory()) {
			File[] list = file.listFiles();
			for (File a : list) {
				if (StringUtil.getExtention(a.getName()).equals("png"))	{	// 확장자 png만 출력
					System.out.println(a.getName());
					FileUtil.copy(a.getAbsolutePath(), "d:/temp/images/"+a.getName());
				}
			}
		}
	}

	private static void fileInfo() {
		
		// 파일 정보
		File file = new File("d:/temp/image.png");
		
		System.out.println("파일 크기 : " + file.length());
		System.out.println("파일 이름 : " + file.getName());
	
	}

	private static void makefolder() {
		
		// 폴더 생성
		File file = new File("d:/temp/images");
		file.mkdir();
		
	}

}
