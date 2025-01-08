package javabasic.exapiextra;

public class APIExtra5 {// 문자열을 두 줄 입력하고 첫번째 문자열내에 두번째 문자열이 몇개 존재하는지 출력

	public static void main(String[] args) {
		System.out.println("동일한 문자열은 " + print() + "개 입니다");

	}// main

	static int print() {
		String[] line = APIExtraScanner.line(5);
		String line2 = APIExtraScanner.line();
		int count = 0;
		for (int i = 0; i < line.length; i++) {
			if (line[i] == line2) {
				count++;
			}
		}
		return count;

	}

	static int print2() {
		String[] line = APIExtraScanner.line(5);
		String line2 = APIExtraScanner.line();
		int idx = -1;
		int count = 0;
//		for (int i = 0; i < line.length; i++) {
			while ((idx = line[0].indexOf(line2, idx + 1)) >= 0) {
				count++;
			}
//		}
		return count;
	}

}// class
