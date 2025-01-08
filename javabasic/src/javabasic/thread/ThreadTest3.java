package javabasic.thread;

public class ThreadTest3 {
	public static void main(String[] args) {
		
		Thread hongThread = new HongThread();
		hongThread.start();
		
		Thread kangThread = new KangThread();
		kangThread.start();
		
		// 두개의 스레드가 서로 다른 객체를 사용한다 -> 동기화 할 필요 없음
		// 동기화는 같은 객체(자원)을 공유할때 사용해야 한다
		
	}// main
}// class
