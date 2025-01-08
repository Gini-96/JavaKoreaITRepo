package javabasic.oop.inheritance;

public class VehicleMain {

	public static void main(String[] args) {
	
		Vehicle v1 = new Vehicle();
		System.out.println(v1); // 참조값 , toString 오버라이딩 하면 toString이 실행됨
		System.out.println(v1.getName());
		
		Vehicle v2 = new Car();
		System.out.println(v2);
		System.out.println(v2.getName());
		
		Vehicle v3 = new Bicycle();
		System.out.println(v3);
		System.out.println(v3.getName());
	}
}
