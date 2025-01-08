package javabasic.thread;

public class EvenThread extends Thread{

	private int i = 0;
	
	@Override
	public void run() {
		
		while (true) {
			System.out.println("EvenThread : "+ i);
			i +=2;
			try {
				// 다른 스레드 실행 종료될때까지 현재 스레드 실행 대기
				// odd 스레드 종료될때까지 대기 하므로 odd 만 실행됨
//				this.join();
				
				// 스레드를 종료 시키려면 interrupt 메소드를 이용
				if (i==10) this.interrupt();
				
				Thread.sleep(2000);
			} catch (InterruptedException ie) {
//				ie.printStackTrace();
				System.exit(0);
			}
		}
	
	
	}
}// class
