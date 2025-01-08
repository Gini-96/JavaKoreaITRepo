package javabasic.exexception;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt(); // 내가 입력한것
//		int b = scanner.nextInt();
//		try {
//			int c = a/b;
//			System.out.println(c);
//		} catch (ArithmeticException ae) {
//			System.out.println("0으로 나눌수 없습니다");
//		}
		

		try {
			int i1 = 0;
			int i2 = 0;
			
			double d1 = scanner.nextDouble();
			double d2 = scanner.nextDouble();
			
			if (!Double.isNaN(d1)) {
				i1 = (int) d1;
			}
			if (!Double.isNaN(d2)) {
				i2 = (int) d2;
			}
			
			if (i1 > Integer.MAX_VALUE || i1 < Integer.MIN_VALUE) {
				try {
					throw new Exception();
				} catch (Exception ex) {
					System.out.println("int의 범위를 넘어갔습니다");
				}
			}
			System.out.println(i1 / i2);
		} catch (NumberFormatException nfe) {
			System.out.println("숫자를 입력해 주세요");
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌수 없습니다");
		} finally {
			scanner.close();
		}


	}// main
}// class
