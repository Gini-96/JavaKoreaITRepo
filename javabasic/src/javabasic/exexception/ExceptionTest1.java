package javabasic.exexception;


public class ExceptionTest1 {
	
	long[] longArr = new long[1024*1024*1024];
	public static void main(String[] args) {
		a();
//		new ExceptionTest1();
		
//			int i = 1;
//		while (true) {
//			makeName("name", Double.MAX_VALUE);
//			System.out.println(i);
//			i++;
//		}
	}// main
	String name;
	double num;
//	public ExceptionTest1 (String name,double num) {
//		this.name = name;
//		this.num = num;
//	}
//	public static void makeName (String name, Double num) {
//		ExceptionTest1 makename = new ExceptionTest1(name, num);
//	}
	
	static void a() {
		b();
	}
	
	static void b() {
		a();
	}
	
}// class
