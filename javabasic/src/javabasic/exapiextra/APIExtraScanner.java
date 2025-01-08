package javabasic.exapiextra;

import java.util.Scanner;

public class APIExtraScanner {

	
	static String line() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 입력해주세요");
		String line = scanner.nextLine();
		scanner.close();
		return line;
	}
	
	static String[] line(int lineCount) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("문자열을 " + lineCount + "개 입력해주세요");
		String[] lineArr = new String[lineCount];
		for (int i=0; i<lineCount; i++) {
			lineArr[i] = scanner.nextLine();
		}
//		scanner.close();
		return lineArr;
	}
}
