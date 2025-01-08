package javabasic.exapiextra;

public class APIExtra8 {

	public static void main(String[] args) {

	}// main

	static void print2() {

		String line = APIExtraScanner.line(1)[0];
		char[] chArr = line.toCharArray();
		int upperCaseCount = 0;
		int lowerCaseCount = 0;
		int numCaseCount = 0;
		int symCaseCount = 0;
		StringBuilder sb = new StringBuilder();
		for (char ch : chArr) {
			if ((int) ch >=65 && (int) ch <= 90) {
				upperCaseCount++;
			} 
			else if ((int) ch >=97 && (int) ch <=122) {
				lowerCaseCount++;
			}
			else if ((int) ch >=48 && (int) ch <=57) {
				numCaseCount++;
			}
			else {
				symCaseCount++;
			}
		}

		System.out.println("대문자의 개수는:" + upperCaseCount + "소문자의 개수는:" + lowerCaseCount + 
				"숫자의 개수는:" + numCaseCount + "기호의 개수는:" + symCaseCount);

	}
}// class
