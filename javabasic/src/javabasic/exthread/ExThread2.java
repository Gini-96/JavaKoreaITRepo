package javabasic.exthread;

public class ExThread2 {

	boolean printThread = false;
	
	public static void main(String[] args) {

		ExThread2 et2 = new ExThread2();
		Thread upperThread = new UpperThread(et2);
		upperThread.start();

		Thread lowerThread = new LowerThread(et2);
		lowerThread.start();


		
//		if (printThread == true) {
//			upperThread.start();
//			printThread = false;
//		}
//		if (printThread == false) {
//			lowerThread.start();
//			printThread = true;
//		}
		
	}// main
}// class
