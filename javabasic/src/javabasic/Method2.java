package javabasic;

public class Method2 {

	public static void main(String[] args) {

		// Cannot make a static reference to the non-static method print ...
		// -> static 메소드인 main 에서 non-static 메소드인 print를 객체 없이 호출 할 수 없다
		// print("Hello Java");
		// Method2.print("Hi Java");

		// Method2 타입의 객체를 생성
		Method2 method2 = new Method2();
		
		// 객체참조를 통해 print 호
		method2.print("Hello Java");
		System.out.println(method2.add(5, 10));
		
		
	}// main

	// non-static 메소드 : 객체를 생성해서 객체로 접근(호출) 하는 메소드
	void print(String str) {
		System.out.println(str);
	}

	int add(int a, int b) {
		return a + b;
	}

}// class
