package javabasic.oop.exinheritance;

public class Glider extends AirCraft{

	public boolean isEngine() {
		return false;
	}
	
	public String getName() {
		return "HangGlider";
	}
	
	public int getMaxCrew() {
		return 1;
	}

}
