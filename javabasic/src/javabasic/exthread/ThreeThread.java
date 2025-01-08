package javabasic.exthread;

public class ThreeThread extends Thread {

	private int i = 3;

	@Override
	public void run() {

		while (true) {
			System.out.println("3의 배수 :" + i);
			i += 3;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}// run
}// class
