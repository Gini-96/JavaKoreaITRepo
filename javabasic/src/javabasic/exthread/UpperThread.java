package javabasic.exthread;

public class UpperThread extends Thread{

	private int upperNum = 65;
	ExThread2 et2;
	public UpperThread(ExThread2 et2) {
		this.et2 = et2;
	}
	
	@Override
	public void run() {
		
		for (int i=0; i<26; i++) {
			synchronized (et2) {
				if (!et2.printThread) System.out.println((char)(upperNum+i));
				et2.printThread = true;
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		
		
	}// run
}// class
