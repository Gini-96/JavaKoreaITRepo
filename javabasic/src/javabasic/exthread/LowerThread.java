package javabasic.exthread;

public class LowerThread extends Thread{

	private int lowerNum = 97;
	ExThread2 et2;
	public LowerThread(ExThread2 et2) {
		this.et2 = et2;
	}
	@Override
	public void run() {
		
		for (int i=0; i<26; i++) {
			synchronized (et2) {
				if (et2.printThread) System.out.println((char)(lowerNum+i));
				et2.printThread = false;
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
	}// run
}// class
