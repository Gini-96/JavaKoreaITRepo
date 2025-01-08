package javabasic.exoop4;

public class CakeMain {

	public static void main(String[] args) {

		Cake moca = new Cake("모카") {
			@Override
			public String getName() {
				return super.getName();
			}
		};
		System.out.println(moca.getName()+ "케잌을 만들었습니다");
		
		makeCake("모카");
		makeCake("초코");
		makeCake("당근");
		
		
		
		
		
		Cake cake = new Cake();
		cake.make();

		Cake moca2 = new Cake() {
			public void make() {
				System.out.println("모카케이크가 만들어 졌습니다");
			}
		};
		moca2.make();
		Cake choco2 = new Cake() {
			public void make() {
				System.out.println("초코케이크가 만들어 졌습니다");
			}
		};
		choco2.make();

	}// main
	
	public static void makeCake(String name) {
		Cake cake = new Cake(name) {
			@Override
			public String getName() {
				return name;
			}
		};
		System.out.println(cake.getName()+ " 케이크를 만들었습니다");
		
	}
	
}// class
