package javabasic.exapiextra;

public class APIExtra7 {

	public static void main(String[] args) {
		print2();
	}// main

	static void print() {

		String line = APIExtraScanner.line(1)[0];
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (char ch : chArr) {
			if (Character.isUpperCase(ch)) {
				sb.append(Character.toLowerCase(ch));
			}
			else {
				sb.append(Character.toUpperCase(ch));
			}
		}

		System.out.println(sb);
		
	}
	static void print2() {
		
		String line = APIExtraScanner.line(1)[0];
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (char ch : chArr) {
			if ((int)ch < 95) {
				sb.append((char)((int)ch+32));
			}
			else {
				sb.append((char)((int)ch-32));
			}
		}
		
		System.out.println(sb);
		
	}
}// class
