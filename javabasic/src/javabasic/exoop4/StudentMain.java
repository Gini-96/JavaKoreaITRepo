package javabasic.exoop4;

public class StudentMain {

	public static void main(String[] args) {

		makeStudent("홍길동", 100, 95, 88);
		makeStudent("강감찬", 89, 99, 76);
		makeStudent("홍길동", 87, 90, 91);

	}// main

	public static void makeStudent(String name, int kor, int eng, int math) {
		Student student = new Student(name);
		student.score = new Student.Score(kor, eng, math);
		printScore(student);
	}
	
	
	
	public static void printScore(Student student) {
		System.out.println("학생의 이름은 " + student.name);
		System.out.println(student.name + "의 국어점수는" + student.score.korean);
		System.out.println(student.name + "의 영어점수는" + student.score.english);
		System.out.println(student.name + "의 수학점수는" + student.score.math);
		System.out.println(student.name + "의 총점수는" + student.score.getSum());
		System.out.println(student.name + "의 평균점수는" + student.score.getAvg());
		System.out.println();
	}

}// class
