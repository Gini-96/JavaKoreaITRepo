package javabasic.excollection;

public class StudentBySir {
	
	private String name;
	private ScoreBySir score;
	
	public StudentBySir() {
	}

	public StudentBySir(String name, ScoreBySir score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ScoreBySir getScore() {
		return score;
	}

	public void setScore(ScoreBySir score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return name + "은 " + score;
	}

}











