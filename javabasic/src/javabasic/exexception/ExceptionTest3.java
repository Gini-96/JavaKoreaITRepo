package javabasic.exexception;

public class ExceptionTest3 {

	public static void main(String[] args) {

		makePerson("홍길동", "산적");
		makePerson("강감찬", "장군");
		makePerson("이순신", "장군");
		makePerson("임꺽정", "산적");
		makePerson("권율", "장군");

	}// main

	public static void makePerson(String name, String job) {
		Person person = new Person(name, job);
		// 생성된 객체의 직업이 산적이면
		// or if (new Person(name, job).getJob().equals("산적")) {
		if ((person).getJob().equals("산적")) {
			try {
				// JobException 을 발생
				throw new JobException();
			} catch (JobException je) {
				System.out.println(je);
			}
		}
		else {
			System.out.println("이름은 "+ name);
			System.out.println("직업은 " + job + "입니다");
		}
	}

}// class
