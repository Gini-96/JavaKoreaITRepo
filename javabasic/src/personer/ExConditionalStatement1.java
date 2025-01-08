package personer;

import java.util.Scanner;

public class ExConditionalStatement1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input1 = scanner.nextInt();
		int input2 = scanner.nextInt();
		
		if (input1 + input2 > 10) {
			System.out.println("10보다 크다");
		}
		else {
			System.out.println("10보다 크지 않다");
		}
		
		scanner.close();
	}
}
