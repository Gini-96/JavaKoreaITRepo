package javabasic.exthread;

public class ExThread1 {

	public static void main(String[] args) {
		
		Thread three = new ThreeThread();
		three.start();
		
		Thread five = new FiveThread();
		five.start();
		
	}// main
}// class
