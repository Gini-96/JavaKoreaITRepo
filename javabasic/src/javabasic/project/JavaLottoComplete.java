package javabasic.project;

import java.util.Arrays;
import java.util.Scanner;

public class JavaLottoComplete {

	public static void main(String[] args) {

		System.out.println("숫자를 하나씩 입력해주세요");
		resultLotto();
	}// main

	// 0~45까지의 랜덤 숫자 생성
	static int setRandomNum() {
		int setRandomNum = (int) (Math.random()*45 + 1); 
		return setRandomNum;
	}

	// 중복되지 않는 랜덤 숫자 6개 생성하고 리턴
	// 0이 나오거나 중복된 숫자가 나올 경우 다시 뽑기
	static int[] inputRandomNum() {
		int[] inputRandomNum = new int[6];
		for (int i = 0; i < inputRandomNum.length; i++) {
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

	// 배열에 저장되어 있는 6개의 숫자를 오름 차순으로 정리

	static int[] ascendRandomNum() {
		int[] ascendRandomNum = inputRandomNum();
		Arrays.sort(ascendRandomNum);
		return ascendRandomNum;
	}
	
	// 정리된 랜덤 6가지 숫자를 고정으로 입력
	
	static final int[] ascendRandomNum = ascendRandomNum();

	//미리 뽑아둔 6개의 랜덤 숫자와 중복 되지 않는 보너스 숫자를 생성
	static int luckyNum() {
		int luckyNum = (int) setRandomNum();
		for (int i=0; i<ascendRandomNum.length; i++) {
			if (ascendRandomNum[i] == luckyNum) {
				luckyNum = (int) setRandomNum();
				i=-1;
			}
		}
		return luckyNum;
	}
	// 6개의 숫자를 입력 받기

	static int[] inputNum() {
		int[] inputNum = new int[6];
		int inputNumLength = inputNum.length;
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < inputNumLength; i++) {
			inputNum[i] = scanner.nextInt();
			if (inputNum[i] == 0 || inputNum[i] > 45) {
				System.out.println("범위에 맞는 번호를 다시 입력해 주세요");
				i=-1;
			}
			for (int j = 0; j < i; j++) {
				if (inputNum[i] == inputNum[j] ) {
					System.out.println("중복 된 번호 입니다\n다시 입력해주세요");
					i=-1;
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
		System.out.println("입력하신 번호는");
		for (int i : ascendNum) {
			System.out.print(i + " ");
		}
		System.out.println("입니다");
		return ascendNum;
	}

	// 입력한 6개의 숫자와 랜덤으로 지정된 6개의 추첨번호 와 1개의 보너스 번호를 비교
	
	static int compNums() {
		int corNumCount = 0;
		int[] compNum = ascendNum();
		System.out.println("추첨 번호는");
		for (int i : ascendRandomNum ) {
			System.out.print(i + " ");
		}
		System.out.println("이고");
		int luckyNum = luckyNum();
		System.out.println("보너스 번호는 " +luckyNum + " 입니다");
		for (int i=0; i<compNum.length; i++) {
			if (compNum[i]==luckyNum) {
				corNumCount=10;
			}
		}
		for (int i=0; i<compNum.length; i++) {
			for (int j=0; j<compNum.length; j++) {
				if (compNum[i]==ascendRandomNum[j]) {
					corNumCount++;
				}
			}
		}
		return corNumCount;
	}
	
	
	// 출력된 점수에 따라 알맞는 등수를 출력
	static void resultLotto() {
		int corNumCount = compNums();
		System.out.print("당첨 결과는 ");
		if (corNumCount ==15) {
			System.out.println("2등입니다");
		}
		else if (corNumCount >= 10 && corNumCount != 15) {
			System.out.println("8등입니다");
		}
		else {
			switch (corNumCount) {
			case 6: System.out.println("1등입니다"); break;
			case 5: System.out.println("3등입니다"); break;
			case 4: System.out.println("4등입니다"); break;
			case 3: System.out.println("5등입니다"); break;
			case 2: System.out.println("6등입니다"); break;
			case 1: System.out.println("7등입니다"); break;
			case 0: System.out.println("8등입니다");
			}
		}
	}
	

}// class