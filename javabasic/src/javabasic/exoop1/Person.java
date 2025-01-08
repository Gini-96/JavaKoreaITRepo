package javabasic.exoop1;

public class Person {

	int restTime;
	
	Information information;
	Job job;
	EducationHistory educationHistory;
	Hobby hobby;

	public Person(Information information, Job job, EducationHistory educationHistory, Hobby hobby) {
		this.information = information;
		this.job = job;
		this.educationHistory = educationHistory;
		this.hobby = hobby;
	}
	
	public int getRestTime () {
		return this.restTime;
	}
	
	public void setRestTime () {
		this.restTime = 24-(job.dailyWorktime + hobby.dailyTime + information.sleepTime);
	}
}

// 평가 : 구성은 나쁘지 않았으나 결국 사람 자체 적인 것 보다는 사람의 정보에 좀더 치우쳐 져 있기 때문에 클래스의 이름을 person이 아닌 personInformation 처럼
// 		 "사람의 정보" 로 하는것이 좀더 구성한 것에 알 맞는 네이밍 인것 같다.