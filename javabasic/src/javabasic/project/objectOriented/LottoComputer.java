package javabasic.project.objectOriented;

public class LottoComputer {// 입력된 번호와 랜덤으로 출력된 번호를 비교하고 결과값을 출력해주는 클래스


	static int COR_NUM_COUNT = compNums();

	// 입력한 6개의 숫자와 랜덤으로 지정된 6개의 추첨번호 와 1개의 보너스 번호를 비교

	static int compNums() {
		
		int corNumCount = 0;
		for (int i = 0; i < LottoMacine.LOTTO_RANDOM_NUM.length; i++) {
			if (LottoPaper.LOTTO_INPUT_NUM[i] == LottoMacine.LOTTO_LUCKY_NUM) {
				corNumCount = 10;
			}
		}
		for (int i = 0; i < LottoMacine.LOTTO_RANDOM_NUM.length; i++) {
			for (int j = 0; j < LottoMacine.LOTTO_RANDOM_NUM.length; j++) {
				if (LottoPaper.LOTTO_INPUT_NUM[i] == LottoMacine.LOTTO_RANDOM_NUM[j]) {
					corNumCount++;
				}
			}
		}
		return corNumCount;
	}
}// class
