package javabasic.thread;

public class HongThread2 extends Thread{

	private Account2 hongAccount2;
	
	public HongThread2(Account2 account2) {
		this.hongAccount2 = account2;
	}
	
	@Override
	public void run() {
		
		// 객체 동기화 방법
		// 1. 메소드 동기화 : 메소드 앞에 synchronized, 메소드 내의 모든 객체가 동시에 동기화
		// 2. 동기화 블럭 : synchronized (동기화할객체) {}, 블럭내에서 지정한 객체만 동기화
		
		for (int i=0; i<10; i++) {
			// 홍 계좌에서 1000원을 출금
//			hongAccount2.setMoney(hongAccount2.getMoney()-500);
			// 1. 메소드 동기화
//			withdraw();
			hongAccount2.withdraw();
			
			//2.객체 동기화(동기화 블럭)
			synchronized (hongAccount2) {
				hongAccount2.setMoney(hongAccount2.getMoney()-500);
			}
			
			System.out.println("홍길동의 계좌에서 500원 출금");
			System.out.println(hongAccount2+"\n");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}// run
	
	//동기화 메소드
	// 홍 스레드가 withdraw 메소드를 실행하는 동안 다른 스레드 들은 withdraw 내에 있는
	// 모든 객체의 락을 얻을 수 없음 = 홍스레드에게만 락을 부여
	private synchronized void withdraw() {
		hongAccount2.setMoney(hongAccount2.getMoney()-500);
	}
	
}// class
