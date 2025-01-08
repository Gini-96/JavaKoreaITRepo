package personer;

import java.util.Scanner;

public class ExArray4 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String[][] inputArr = new String[3][4];
		int[] totalArr = new int[3];
		int[] meanArr = new int[3];

		int inputArrLength = inputArr.length;
		int inputArr0Length = inputArr[0].length;

		for (int i = 0; i < inputArrLength; i++) {
			for (int j = 0; j < inputArr0Length; j++) {
				inputArr[i][j] = scanner.next();
				if (j > 0) {
					totalArr[i] += Integer.parseInt(inputArr[i][j]);
				}
			}
			meanArr[i] = totalArr[i] / inputArr0Length - 1;
		}

		for (int i = 0; i < inputArrLength; i++) {
				System.out.println("이름 : " + inputArr[i][0]);
				System.out.println("국어점수 : "+ inputArr[i][1]);
				System.out.println("수학점수 : "+ inputArr[i][2]);
				System.out.println("영어점수 : "+ inputArr[i][3]);
				System.out.println("총점 : "+ totalArr[i]);
				System.out.println("평균점수 : "+ meanArr[i]);
			}
		// 조건을 새밀하게 넣지 않아서 무지성으로 넣어서 출력 수정 필요
		for (int i = 0; i< inputArrLength; i++) {
			for (int j = 0; j < inputArr0Length; j++) {
				System.out.println("이름 : " + inputArr[i][j]);
				System.out.println("국어점수 : "+ inputArr[i][j]);
				System.out.println("수학점수 : "+ inputArr[i][j]);
				System.out.println("영어점수 : "+ inputArr[i][j]);
				System.out.println("총점 : "+ totalArr[i]);
				System.out.println("평균점수 : "+ meanArr[i]);
			}
		}
		
		scanner.close();

	}// main
}// class
