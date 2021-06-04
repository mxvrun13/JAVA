package co.friend.util;

public class StringUtil {
	public static String getFilename(String path) {
		String s = null;
		if (path == null) return null;
		s = path.substring(path.lastIndexOf("/")+1);		
		return s;
	}
	public static String getExtention(String path) {
		String s = null;
		if (path == null) return null;
		s = path.substring(path.lastIndexOf(".")+1);
		return s;
	}
	public static String getPath(String path) {
		String s = null;
		if (path == null) return null;
		s = path.substring(0, path.lastIndexOf("/"));
		return s;
	}
}