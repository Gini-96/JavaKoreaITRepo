package javabasic.exapiextra;

public class APIExtra6 {// 문자 10개를 공백과 함꼐 입력하면 모두 합쳐진 
	
	public static void main(String[] args) {
		print();
	}

	static void print() {
		
		String line = APIExtraScanner.line(1)[0];
		char[] chArr = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		for (char ch : chArr) {
			if (ch!=' ') {
				sb.append(ch);
			}
		}
		
		System.out.println(sb);
	}
}
