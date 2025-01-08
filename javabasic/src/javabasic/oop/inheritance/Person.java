package javabasic.oop.inheritance;

public class Person {

	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this.name.equals(((Person)obj).name) && this.age==((Person)obj).age) {
			return true;
		}
		else {
			return false;
		}
	}
}
