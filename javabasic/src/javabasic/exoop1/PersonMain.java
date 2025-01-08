package javabasic.exoop1;

public class PersonMain {

	public static void main(String[] args) {
		
		Information information = new Information();
		
		information.name = "홍길동";
		information.country = "Korea";
		information.sex = "male";
		information.age = 30;
		information.sleepTime = 7;

		EducationHistory eduHistory = new EducationHistory();
		
		eduHistory.lastDegree = "college";
		eduHistory.studyAbroad = false;
		
		Job job = new Job();
		
		job.nowWorking = true;
		job.name = "회사원";
		job.dailyWorktime = 9;
		job.salary = 3000000;
		
		Hobby hobby = new Hobby();
		
		hobby.name = "헬스";
		hobby.dailyTime = 1;
		
		Person person = new Person(information, job, eduHistory, hobby);
		
		person.setRestTime();
		System.out.println(information.name + "의 하루 여유시간은" + person.getRestTime() + "입니다.");
		
		
		
		
	}// main
}// class
