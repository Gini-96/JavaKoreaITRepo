package personer;

import java.util.Scanner;

public class ExMethod3 {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		inputDouble(scanner.nextDouble(), scanner.nextDouble(), scanner.next());//이부분을 출력하는 메소드를 만들어서 좀더 심플하게 변경
	}//main
	
	
	static void inputDouble(double a, double b, String str) {
		if (str.equals("+")) {
			System.out.println(a+b);
		}
		else if (str.equals("-")) {
			System.out.println(a-b);
		}
		else if (str.equals("*")) {
			System.out.println(a*b);
		}
		else if (str.equals("/")) {
			System.out.println(a/b);
		}
		else {
			System.out.println("Type again");
		}
	}//기능의 분활 필요 (계산과 출력부분)
	
	
}//class


