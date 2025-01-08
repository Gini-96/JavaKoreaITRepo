package javabasic.project;

import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.SortOrder;

// Java Lotto : 개인 Java 프로젝트
// [Lotto 프로그램 구현]
// 1. 기능
// 1) 사용자에게 1~45중 중복되지 않은 6개의 정수를 입력 받는다.
// 2) 중복되지 않은 7개의 정수를 랜덤하게 뽑아낸다. (앞의 6개는 로또번호, 7번째는 보너스 번호)
// 3) 로또 당첨규칙에 따라서 사용자의 당첨등수를 출력한다.
// 2. 규칙
// 1) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호가 모두 일치하면 1등
// 2) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호중 5개가 일치하고 보너스번호가 일치하면 2등
// 3) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호중 5개가 일치하면 3등
// 4) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호중 4개가 일치하면 4등
// 5) 사용자가 입력한 6개의 로또번호와 프로그램이 랜덤하게 뽑은 앞의 6개 번호중 3개가 일치하면 5등
// 6) 나머지는 꽝! 다음기회에!
// 3. 출력 형식
// 로또번호 6개를 입력해 주세요!
// 21 3 8 9 40 33
// 추첨번호는 3 8 33 22 10 34 (보너스 번호:45) 
// 5등입니다!
public class JavaLotto {

	public static void main(String[] args) {

		// 랜덤 정수 추출
		// Math.random() : 0.0<=n<1.0 범위의 실수를 반환
		// int randomNumber = (int) (Math.random() * 10) + 1; // 1~10
		System.out.println("숫자를 하나씩 입력해주세요");
		int saveNum[] = ascendNum();
		int saveNumLength = saveNum.length;
		for (int i = 0; i < saveNumLength; i++) {
			System.out.println(saveNum[i]);
		}
		
		for (int i : saveNum) {
			System.out.println("입력하신 번호는");
			
		}
		
		System.out.println("추첨 번호는");
		int saveRandomNum[] = ascendRandomNum();
		int saveRandomNumLength = saveRandomNum.length;
		for (int i = 0; i < saveRandomNumLength; i++) {
			System.out.print(saveRandomNum[i] + ",");
		}
		System.out.println("입니다");
		System.out.println("행운번호는" +LuckyNum() + "입니다");

	}// main

	// 0~45까지의 랜덤 숫자 생성
	static int setRandomNum() {
		int setRandomNum = (int) (Math.random() * 10 + Math.random() * 10 + Math.random() * 10 + Math.random() * 10
				+ Math.random() * 10);
		return setRandomNum;
	}

	// 중복되지 않는 랜덤 숫자 7개 생성하고 리턴
	// 0이 나오거나 중복된 숫자가 나올 경우 다시 뽑기
	static int[] inputRandomNum() {
		int[] inputRandomNum = new int[6];
		int inputRandomNumLength = inputRandomNum.length;
		for (int i = 0; i < inputRandomNumLength; i++) {
			inputRandomNum[i] = (int) setRandomNum();
			if (inputRandomNum[i] == 0) {
				i--;
			}
			for (int j = 0; j < i; j++) {
				if (inputRandomNum[i] == inputRandomNum[j] || inputRandomNum[j] == 0) {
					i--;
				}
			}
		}
		return inputRandomNum;
	}
	//미리 뽑아둔 6개의 랜덤 숫자와 중복 되지 않는 보너스 숫자를 생성
	static int LuckyNum() {
		int[] totalRandomNum = inputRandomNum();
		int totalRandomNumLength = totalRandomNum.length;
		int luckyNum = 0;
		for (int i=0; i<totalRandomNumLength; i++) {
			luckyNum = (int) setRandomNum();
			if (totalRandomNum[i] != luckyNum) {
				++i;
			}
		}
		return luckyNum;
	}

	// 배열에 저장되어 있는 6개의 숫자를 오름 차순으로 정리

	static int[] ascendRandomNum() {
		int[] ascendRandomNum = inputRandomNum();
		Arrays.sort(ascendRandomNum);
		return ascendRandomNum;
	}
	
	// 6개의 숫자를 입력 받기

	static int[] inputNum() {
		int[] inputNum = new int[6];
		int inputNumLength = inputNum.length;
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < inputNumLength; i++) {
			inputNum[i] = scanner.nextInt();
			if (inputNum[i] == 0 || inputNum[i] > 45) {
				System.out.println("숫자를 다시 입력해 주세요");
				i--;
			}
			for (int j = 0; j < i; j++) {
				if (inputNum[i] == inputNum[j] || inputNum[j] == 0) {
					System.out.println("숫자를 다시 입력해 주세요");
					i--;
				}
			}
		}

		scanner.close();

		return inputNum;

	}

	// 6개의 숫자를 오름 차순으로 정리
	
	static int[] ascendNum() {
		int[] ascendNum = inputNum();
		Arrays.sort(ascendNum);
		return ascendNum;
	}

	// 입력한 6개의 숫자와 랜덤으로 지정된 6개의 숫자를 비교
	
	
	
	// 지정된 등수에 알맞는 답변을 출력
	
//	static void randomNum () {
//		int randomNum1 = (int) setRandomNum();
//		if (randomNum1 > 0 ) {
//			int randomNum2 = (int) setRandomNum();
//			if (randomNum2 > 0 && randomNum1 != randomNum2) {
//				int randomNum3 = (int) setRandomNum();
//				if (randomNum3 > 0 && randomNum1 != randomNum3 && randomNum2 !=randomNum3 ) {
//					int randomNum4 = (int) setRandomNum();
//					if (randomNum4 > 0 && randomNum1 != randomNum4 && randomNum2 !=randomNum4 && randomNum3 !=randomNum4 ) {
//						int randomNum5 = (int) setRandomNum();
//						if (randomNum5 > 0 && randomNum1 != randomNum5 && randomNum2 !=randomNum5 && randomNum3 !=randomNum5 && randomNum4 !=randomNum5 ) {
//							int randomNum6 = (int) setRandomNum();
//							if (randomNum6 > 0 && randomNum1 != randomNum6 && randomNum1 !=randomNum3 ) {
//								System.out.println(randomNum1);
//								System.out.println(randomNum2);
//								System.out.println(randomNum3);
//								System.out.println(randomNum4);
//								System.out.println(randomNum5);
//								System.out.println(randomNum6);
//							}
//						}
//					}
//				}
//			}
//		}
//	}
//	static void inputNum() {
//		// 스캐너 생성
//		Scanner scanner = new Scanner(System.in);
//		// 한 라인의 문자열 입력
//		String line = scanner.nextLine();
//
//		// 문자열을 공백문자 기준으로 토크나이징(토큰으로 분리)
//		StringTokenizer st = new StringTokenizer(line);
//
//		// 토큰이 있는 동안 반복
//		while (st.hasMoreTokens()) {
//			// 토큰 하나씩 가져와서 출력
//			String token = st.nextToken();
//			System.out.println(token);
//		}
//
//		scanner.close();
//
//	}

}// class
