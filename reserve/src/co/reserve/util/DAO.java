package co.reserve.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	
		public Connection conn;
		
		protected DAO() {
			String url = "jdbc:sqlite:C:/sqlite/db/re.db";
			try {
				conn = DriverManager.getConnection(url);
				System.out.println("연결 성공");				
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
