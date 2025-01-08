package javabasic.exapiextra;

public class APIExtra1 { // 문자열을 한 줄 입력받아서 문자열의 길이를 출력

	public static void main(String[] args) {
		
		showLength();
	}// main
	
	private static void showLength() {
		
		String line = APIExtraScanner.line();
		int lineNum = line.length();
		System.out.println(lineNum);
	
	
	}
	
	
	
	
}// class

