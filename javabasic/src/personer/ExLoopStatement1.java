package personer;

import java.util.Scanner;

public class ExLoopStatement1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		for (int j = 1; j < 10; j = j + 1) {
		System.out.println(j*i);
		}
		scanner.close();
	}
}
