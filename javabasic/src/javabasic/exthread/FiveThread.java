package javabasic.exthread;

public class FiveThread extends Thread{

	private int i = 5;

	@Override
	public void run() {

		while (true) {
			System.out.println("5의 배수 :" + i);
			i += 5;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}

	}// run
}
