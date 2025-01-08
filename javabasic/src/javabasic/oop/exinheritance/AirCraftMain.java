package javabasic.oop.exinheritance;

public class AirCraftMain {

	public static void main(String[] args) {
		
	AirCraft fighter = new Fighter();
	
	AirCraft airLiner = new AirLiner();
	
	AirCraft glider = new Glider();

	System.out.println(fighter.getName());
	
	}
}
