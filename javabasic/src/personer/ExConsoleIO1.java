package personer;

import java.util.Scanner;

public class ExConsoleIO1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int firstInt = 0;
		int secondInt = 0;
		
		if (scanner.hasNext()) {
			firstInt = scanner.nextInt();
			
		}
		if (scanner.hasNext()) { // 위의 if 문과 합치기 가능
			secondInt = scanner.nextInt();
			
		}
		
		int sum = firstInt * secondInt;
		
		System.out.println("두 수의 곱은" + sum + "입니다");
		
		scanner.close();
		
	}
	
	
}
