package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SqliteConnect {
	// 어디서든 쓸 수 있도록 필드로 선언
	static PreparedStatement psmt;
	static ResultSet rs;
	static Connection conn;
	
	// 1. 조회, 2. 입력, 3. 수정, 4. 삭제, 5. 전체 리스트 -> 메소드로 기능 분리
	
	// 전체 리스트
	public static ArrayList<Person> getPersonList() {	// static이 없으면 인스턴스 생성해서 호출해야함
		
		ArrayList<Person> personList = new ArrayList<>();
		connect();	// Connection 객체 연결
		String sql = "select * from Person";	// 실행할 쿼리
		try {
			psmt = conn.prepareStatement(sql);	//PreparedStatement 쿼리를 실행, 결과를 받아 옴
			rs = psmt.executeQuery();	// 쿼리의 실행 결과 가져와 rs에 담음
								
			while(rs.next()) {	// 데이터를 다 담을 때까지 반복
				// System.out.println(rs.getInt("id")+", "+rs.getString("main"));
				Person person = new Person();	// Person 클래스
				person.setId(rs.getInt("id"));	// set 메소드 매개변수에 따라 int, string
				person.setName(rs.getString("main"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;	// 리턴 타입
	}
	// 한 건 조회
	public static Person getPerson(int id) {
		connect();
		String sql = "select * from Person where id = ?";
		Person p = null;	// 여기서 new를 생성하면 p는 null이 아님, 52행
		try {
			psmt = conn.prepareStatement(sql);	// PreparedStatement 객체 생성
			psmt.setInt(1, id);		// ?에 매개변수를 넣어 실행
			rs = psmt.executeQuery();	// select 할 때만
			
			if(rs.next()) {		// 데이터가 있으면 인스턴스 할당
				p = new Person();	// Person 타입 인스턴스 할당
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("main"));
				p.setAge(rs.getInt("age"));
				p.setPhone(rs.getString("phone")); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return p;		
	}
	// 입력 기능
	public static void insertPerson(int id, String name, int age, String phone) {	// 리턴 타입 없음
		connect();
		String sql = "insert into Person values (?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);		// 쿼리 구문 실행
			psmt.setInt(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, age);
			psmt.setString(4, phone);
			int r = psmt.executeUpdate();	// insert, update, delete 할 때 사용
			System.out.println(r+"건 입력 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	// 수정 기능
	public static void updatePerson(Person p) {
		connect();
		String sql = "update Person set main = ?, age = ?, phone = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, p.getName());
			psmt.setInt(2, p.getAge());
			psmt.setString(3, p.getPhone());
			psmt.setInt(4, p.getId());
			int r = psmt.executeUpdate();
			System.out.println(r+"건 변경 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	// 삭제 기능
	public static void deletePerson(int id) {
		connect();
		String sql = "delete from Person where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			int r = psmt.executeUpdate();
			System.out.println(r+"건 삭제 완");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}	
	}
	// 이름 조회
	public static ArrayList<Person> findName(String name) {
		ArrayList<Person> personList = new ArrayList<>();
		connect();
		String sql = "select * from Person where main = ?";
		Person person = null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();
			while (rs.next()) {
				person = new Person();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("main"));
				person.setAge(rs.getInt("age"));
				person.setPhone(rs.getString("phone"));
				personList.add(person);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return personList;
	}
	public static void connect() {
		String url = "jdbc:sqlite:C:/sqlite/db/sample.db";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("연결 성공");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(psmt!=null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		while(true) {
			System.out.println("1.전체 리스트 2.입력 3.수정 4.삭제 5.한 건 조회 6.이름 조회 0.종료");
			int num = scanner.nextInt();
			if (num==1) {	// 전체 조회
				System.out.println("<조회 결과>");
				ArrayList<Person> list = getPersonList();	// getPersonList 메소드의 리턴 타입이 ArrayList 
				for (Person person : list) {	// 하나씩 출력, sysout(person)하면 한 줄로 출력
					System.out.println(person);
				}			
			} else if (num==2) {	// 입력
				System.out.println("ID를 입력하시오. > ");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				System.out.println("이름을 입력하시오. > ");
				String searchName = scanner.nextLine();
				System.out.println("나이를 입력하시오. > ");
				int searchAge = scanner.nextInt();
				scanner.nextLine();
				System.out.println("전화번호를 입력하시오. > ");
				String searchPhone = scanner.nextLine();
				insertPerson(searchId, searchName, searchAge, searchPhone);			
			} else if (num==3) {	// 수정
				System.out.println("수정할 ID를 입럭하시오. > ");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				Person p = getPerson(searchId);
				if(p==null) {
					System.out.println("조회된 값이 없습니다");
					continue;	// 밑 구문들이 실행되지 않음
				}
				System.out.println("변경할 이름 입력하시오 > ");
				String updatename = scanner.nextLine();
				System.out.println("변경할 나이를 입력하시오 > ");
				String updateage = scanner.nextLine();
				System.out.println("변경할 전화번호를 입력하시오 > ");
				String updatephone = scanner.nextLine();
				if(!updatename.equals("")) {	// 아무 것도 입력하지 않고 엔터 치면 넘어감
					p.setName(updatename);
				}
				if(!updateage.equals("")) {
					p.setAge(Integer.parseInt(updateage));
				}
				if(!updatephone.equals("")) {
					p.setPhone(updatephone);
				}
				updatePerson(p);
			} else if (num==4) {	// 삭제
				System.out.println("ID를 입력하시오. > ");
				int searchId = scanner.nextInt();
				scanner.nextLine();
				deletePerson(searchId);
			} else if (num==5) {	// 한 건 조회
				System.out.println("조회할 ID를 입력하시오. > ");
				int searchId = scanner.nextInt();
				Person p = getPerson(searchId);
				if(p==null) {	// 46행 참조
					System.out.println("조회된 값이 없습니다.");
				} else {
					System.out.println(p);
				}
			} else if (num==6) {
				System.out.println("조회할 이름을 입력하시오. > ");
				String name = scanner.next();
				System.out.println("<조회 결과>");
				ArrayList<Person> list = findName(name);
				if (list.size() != 0) {
					for (Person person : list) {
						System.out.println(person);
					}
				} else if (list.size() == 0) {
					System.out.println("조회된 값이 없습니다.");
				}
			} else if (num==0) {
				break;
			}
		}	// end if while
		scanner.close();
		System.out.println("정상적인 종료.");
	}	// end of main
}	// end of class
