package personer;

import java.util.Scanner;

public class S {

	
	
	public static void main(String[] args) {
		printStar();
	}// main

	static int countStars(int a) {
		Scanner scanner = new Scanner(System.in);
		a = scanner.nextInt();
		scanner.close();
		return a;
			}
	
	static void printStar() {
		int k = S.countStars(1);
		for (int i = 0; i < k; i++) { // 줄의 수 i
			for (int j = 0; j <= i; j++) { // 별의 수 j
				 System.out.print("*");
			}
			System.out.println();
		}
	}

}
// class
