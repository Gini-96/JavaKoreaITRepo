package javabasic.oop;

public class CarMain {

	public static void main(String[] args) {
		
		// Car 타입의 객체를 생성
		// Car 타입의 메모리를 생성하고 생성된 메모리의 주소를 해싱을 통해 참조로 변환하고 그 변환되어 나온 값을 bmw라는 변수에 입력
		Car bmw = new Car();
		
		System.out.println(bmw);
		
		// 객체의 멤버변수들에 값을 할당 (타입에 맞춰서)
		bmw.company = "BMW KOREA";
		bmw.model = "520";
		bmw.name = "BMW";
		bmw.price = 1000;
		
		System.out.println(
				"제조사명 : " + bmw.company + "\n"
				+ "모델명 : " + bmw.model + "\n"
				+ "이름 : " + bmw.name + "\n"
				+ "판매가격 : " + bmw.price
				);
		// 같은 객체 = 주소가 같다 = 참조가 같다 = 참조값이 같다
		// 메모리상에 같은 곳에 있는 객체를 같은 객체라고 한다
		Car audi = new Car();
		
		System.out.println(audi);
		
		audi.company = "AUDI KOREA";
		audi.model = "A8";
		audi.name = "AUDI";
		audi.price = 1500;
		
		System.out.println(
				"제조사명 : " + audi.company + "\n"
				+ "모델명 : " + audi.model + "\n"
				+ "이름 : " + audi.name + "\n"
				+ "판매가격 : " + audi.price
				);
		// 메모리에 있는 audi 객체의 참조 값을 복사
		// audi2 객체 = audi 객체와 같은 객체
		Car audi2 = audi;
		
		System.out.println(audi2);
		
		audi2.price = 2000;
		
		System.out.println(
				"제조사명 : " + audi2.company + "\n"
				+ "모델명 : " + audi2.model + "\n"
				+ "이름 : " + audi2.name + "\n"
				+ "판매가격 : " + audi2.price
				);
		
		System.out.println(
				"제조사명 : " + audi.company + "\n"
				+ "모델명 : " + audi.model + "\n"
				+ "이름 : " + audi.name + "\n"
				+ "판매가격 : " + audi.price
				);
	} // main
	
	
} // class
