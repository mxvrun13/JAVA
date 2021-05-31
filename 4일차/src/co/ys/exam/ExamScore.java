package co.ys.exam;

public class ExamScore {
	String examNum;
	int kor;
	int his;
	int eng;
	int avg;
	
	ExamScore (String examNum, int kor, int his, int eng) {
		this.examNum = examNum;
		this.kor = kor;
		this.his = his;
		this.eng = eng;
		this.avg = (kor + his + eng) / 3;
	}
	boolean isPass() {
		boolean result;
		if (avg >= 60 && kor >= 40 && his >= 40 && eng >= 40) {
			result = true;
		} else {
			result  = false;
		}
		return result;
	}

}
