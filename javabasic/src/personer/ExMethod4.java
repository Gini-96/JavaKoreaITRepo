package personer;

import java.util.Scanner;

public class ExMethod4 {

	
	
	public static void main(String[] args) {

		printStar(scanner.nextInt());//여기에 스캐너를 넣는것이 아닌 인풋 메소드를 만들어서 거이에 스캐너를 도입
	}// main

	public static Scanner scanner = new Scanner(System.in);
//	static int countStars(int a) {
//		return a;
//			} // 스캐너를 통해 int 값을 한번 받아 쓰고 버릴 메소드기 때문에 성능 적으로 크게 필요가 없음

	public static void printStar(int a) {
		for (int i = 0; i < a; i++) { // 줄의 수 i
			for (int j = 0; j <= i; j++) { // 별의 수 j
				 System.out.print("*");
			}
			System.out.println();
		}
	}

}
// class
