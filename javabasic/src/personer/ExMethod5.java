package personer;

import java.util.Scanner;

public class ExMethod5 {
	
	Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String[][] str = {
				{"홍길동","100","90","80","0","0"},
				{"이순신","95","70","55","0","0"},
				{"강감찬","80","50","30","0","0"}
		};
		scanner.close();
	}//main
	
	
//	static String saveName(String str) {
//		str = scanner.next();
//		return str;
//	}
//	static void saveScore(int a, int b, int c) {
//		a = scanner.nextInt();
//		b = scanner.nextInt();
//		c = scanner.nextInt();
//	}
	static int totalScore(int a, int b, int c) {
		
		return a+b+c;
	}
	static int meanScore(int a, int b, int c) {
		return (a+b+c)/3;
	}
	static void print(String str, int a, int b, int c, int d, int e) {
		System.out.println("이름 : " + str);
		System.out.println("국어점수 : "+ a);
		System.out.println("영어점수 : "+ b);
		System.out.println("국어점수 : "+ c);
		System.out.println("총점수 : "+ d);
		System.out.println("평균점수 : "+ e);
		
	}
	
	
	
}//class
