package javabasic.oop.inheritance;

public class Car extends Vehicle{
	
	private int tireCount;
	
	@Override
	String getName() {
		return "자동차";
	}

	
	@Override
	public String toString() {
		return "Car의 toString";
	}
	
}
