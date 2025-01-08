package javabasic.oop;


public class OuterMain {

	
	public static void main(String[] args) {
		
		// Outer 객체 생성
		Outer outerObject = new Outer();
		//local
		outerObject.print();
		
		// static inner class 객체 생성
		Outer.SIClass outerSIClassObject = new Outer.SIClass();
		outerSIClassObject.print();
		
		// non-static inner class 객체 생성
		// Outer 클래스의 객체를 생성한 후에 Inner 클래스의 객체가 생성될 수 있음
		Outer.NSIClass outerNSIClassObject = new Outer().new NSIClass();
		outerNSIClassObject.print();
		
		Outer.NSIClass outerNSIClassObject2 = outerObject.new NSIClass();
		outerNSIClassObject2.print();
		
	}// main
}// class
