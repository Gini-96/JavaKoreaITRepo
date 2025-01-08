package personer;

import java.util.Scanner;

public class ExConditionalStatement2 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = scanner.nextInt();
		
		if (input >100 ) {
			System.out.println("점수를 다시 입력해 주세요");
		}
		else if (input > 90) {
			System.out.println("A");
		}
		else if (input > 80) {
			System.out.println("B");
		}
		else if (input > 70) {
			System.out.println("C");
		}
		else if (input > 60) {
			System.out.println("D");
		}
		else if (input < 0) {
			System.out.println("점수를 다시 입력해 주세요");
		}
		else {
			System.out.println("F");
		}
		scanner.close();
	}
}
