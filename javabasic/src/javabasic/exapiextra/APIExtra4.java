package javabasic.exapiextra;

public class APIExtra4 {// 문자열을 두 줄 입력하고 첫번째 문자열 내에 두번째 문자열이 존재하는지 출력
	
	public static void main(String[] args) {
		print();
	}// main
	
	
	static void print() {
		String[] line = APIExtraScanner.line(2);
		
		System.out.println(line[0].contains(line[1]) ? "포함한다" : "포함하지않는다");
	}
	
	
	
	
	
	
	
}// class
