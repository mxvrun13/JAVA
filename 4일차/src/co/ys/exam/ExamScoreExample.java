package co.ys.exam;

public class ExamScoreExample {

	public static void main(String[] args) {
		ExamScore examScore = new ExamScore("1234", 60, 40, 40);
		System.out.println(examScore.isPass()? "합격":"불합격");
	}

}
