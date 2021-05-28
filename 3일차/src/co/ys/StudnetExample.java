package co.ys;

public class StudnetExample {

	public static void main(String[] args) {
		StudentApp app = new StudentApp();
		Student student = app.createStudent();
		student.print();
	}
}
