package javabasic.project.objectOriented;

import java.util.Arrays;

public class LottoMacine {// 로또에서 등수를 지정하기 위해 랜덤되는 번호를 출력하는 클래스 (중복되지 않는 일반 번호 6개, 행운 번호 1개)

	static int[] LOTTO_RANDOM_NUM = inputRandomNum();
	static int LOTTO_LUCKY_NUM = luckyNum();

	// 0~45까지의 랜덤 숫자 생성
	static int setRandomNum() {
		int setRandomNum = (int) (Math.random() * 45 + 1);
		return setRandomNum;
	}

	// 중복되지 않는 랜덤 숫자 6개 생성하고 리턴
	// 0이 나오거나 중복된 숫자가 나올 경우 다시 뽑기
	static int[] inputRandomNum() {
		int[] inputRandomNum = new int[6];// 랜덤으로 나올 번호를 저장할 배열을 생성
		for (int i = 0; i < inputRandomNum.length; i++) {// 배열의 처음부터 하나씩 입력된 번호를 저장
			inputRandomNum[i] = (int) setRandomNum();
//			if (inputRandomNum[i] == 0) {
//				i--;
//			}
			for (int j = 0; j < i; j++) {// 이미 저장된 랜덤번호와 중복되는 번호가 나오는지 확인
				if (inputRandomNum[i] == inputRandomNum[j] || inputRandomNum[j] == 0) {
					i--;
				}
			}
		}
		Arrays.sort(inputRandomNum);// 저장된 번호를 순서대로 정렬
		return inputRandomNum;
	}

	// 미리 뽑아둔 6개의 랜덤 숫자와 중복 되지 않는 보너스 숫자를 생성
	static int luckyNum() {
		int luckyNum = (int) setRandomNum();
		for (int i = 0; i < LOTTO_RANDOM_NUM.length; i++) {
			if (LOTTO_RANDOM_NUM[i] == luckyNum) {// 이미 저장된 랜덤번호와 출력된 행운 번호가 중복되는지 확인
				luckyNum = (int) setRandomNum();
				i = -1;
			}
		}
		return luckyNum;
	}

}// class
