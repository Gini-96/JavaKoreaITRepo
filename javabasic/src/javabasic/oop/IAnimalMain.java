package javabasic.oop;

public class IAnimalMain {

	public static void main(String[] args) {
		
		IAnimal dog = new Dog2();
		dog.sound();
		
		IAnimal dog2 = new Dog2() {
			public void sound() {
				System.out.println("강아지는 왈왈 소리를 냅니다");
			}
		};
		dog2.sound();
		
		IAnimal dog3 = new AnimalAdapter() { //어뎁터 대신 인터페이스도 삽입 가능
			public void sound() {
				System.out.println("왈멍");
			}
		};
		dog3.sound();
	}// main
}// class
