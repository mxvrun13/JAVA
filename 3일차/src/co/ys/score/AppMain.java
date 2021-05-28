package co.ys.score;

public class AppMain {

	public static void main(String[] args) {
		ScoreArrApp score = new ScoreArrApp();
		score.printH();
		System.out.println();
		System.out.println("성적");
		score.print();
		System.out.printf("총점 : %04d", score.total());
		System.out.println();
		System.out.printf("평균 : %-10.2f", score.avg());
	}
}
