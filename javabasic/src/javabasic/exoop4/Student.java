package javabasic.exoop4;

public class Student {

	static String name;
	
	Student (String name) {
		this.name = name;
	}
	Score score = new Score(0, 0, 0);
	
	
	static class Score {
		int korean;
		int english;
		int math;
		
		Score (int korean, int english, int math) {
			this.korean = korean;
			this.english = english;
			this.math = math;
		}
		
		public int getSum() {
			return korean + english + math;
		}
		
		public float getAvg() {
			return getSum()/3f;
		}
	}
}// class
