package co.reserve.model;

public class Reserve {
	
	private String id;
	private String date;
	private String time;
	private int num;
	private String input;
	
	
	public Reserve() {}
	
	public Reserve(String id, String date, String time, int num, String input) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.num = num;
		this.input = input;
	}

	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}


	@Override
	public String toString() {
		return "[예약자=" + id + ", 관람 일자=" + date + ", 관람 시간=" + time + ", 인원=" + num + ", 예약 시간=" + input + "]";
	}
	
}
