package co.yedam.app.score;

public class AppMain {

	public static void main(String[] args) {
		ScoreApp score = new ScoreApp();
		score.input();
		System.out.println(score.getSum()+":"+score.getAvg()+":"+score.getGrade());
		System.out.println("합격 여부 : " + (score.isPass() ? "합격":"불합격"));
	}
}
