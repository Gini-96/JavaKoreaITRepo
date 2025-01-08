package javabasic.thread;

public class ThreadTest1 {

	public static void main(String[] args) {
		
		// 쓰레드 객체 생성
		Thread t = new NumberPrintThread();
		
		// 쓰레드 객체의 run 메소드 호출 요청
		t.start();
		
		
	}// main
}// class
