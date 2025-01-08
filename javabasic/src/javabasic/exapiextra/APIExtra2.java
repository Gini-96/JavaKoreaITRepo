package javabasic.exapiextra;

public class APIExtra2 {// "Hello Java"라는 문자열 내의 문자들의 아스키코드 값의 총합을 출력

	public static void main(String[] args) {

		String java = "Hello Java";
		int sum = 0;
		char[] charArr = java.toCharArray();
		for (char ch : charArr) {
			sum += (int) ch;
		}
		System.out.println(sum);
	}// main

}// class
