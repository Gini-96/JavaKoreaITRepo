package javabasic.project.objectOriented;

import java.util.Arrays;
import java.util.Scanner;

public class LottoPaper { // 사용자가 로또의 번호를 입력하는 클래스

	static int[] LOTTO_INPUT_NUM = inputNum();

	static int[] inputNum() {
		int[] inputNum = new int[6];// 입력받을 번호를 저장할 배열을 생성
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < inputNum.length; i++) {// 배열의 처음부터 하나씩 입력된 번호를 저장
			inputNum[i] = scanner.nextInt();
			if (inputNum[i] == 0 || inputNum[i] > 45) {// 1~45 사이의 번호를 입력하였는지 확인
				System.out.println("범위에 맞는 번호를 다시 입력해 주세요");
				i=-1;
			}
			for (int j = 0; j < i; j++) {// 먼저 입력된 번호와 중복된 번호를 입력하는지 확인
				if (inputNum[i] == inputNum[j] || inputNum[j] == 0) {
					System.out.println("중복 되지 않게 번호를 다시 입력해 주세요");
					i=-1;
				}
			}

		}
		scanner.close();

		Arrays.sort(inputNum);// 입력된 번호를 순서대로 정렬
		
		return inputNum;

	}
}// class
