package javabasic.oop.exinheritance;

public class AirLiner extends AirCraft{

	public boolean isEngine() {
		return true;
	}
	
	public String getName() {
		return "Boeing-747";
	}
	
	public int getMaxCrew() {
		return 20;
	}

}
