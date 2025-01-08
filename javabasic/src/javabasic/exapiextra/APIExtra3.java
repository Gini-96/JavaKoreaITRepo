package javabasic.exapiextra;

import java.util.StringTokenizer;

public class APIExtra3 {// 문자 5개를 입력하면 3번째 입력한 문자의 아스키코드값을 출력 -> 문자열 5개로 봐서 주신 문제와는 다른식으로 만들어버림

	public static void main(String[] args) {
		print();
	}// main

	static void print() {
		String line = APIExtraScanner.line();
		String[] stringArr = new String[5];
		int sum = 0;
		for (int i = 0; i < stringArr.length; i++) {
			StringTokenizer st = new StringTokenizer(line.substring(0), " ");
			while (st.hasMoreTokens()) {
				stringArr[i] = st.nextToken();
				i++;
			}
		}
		char[] charArr = stringArr[2].toCharArray();
		for (char ch : charArr) {
			sum += (int) ch;
		}
		System.out.println(sum);
	}
}// class
//apple banana orange pineapple peach