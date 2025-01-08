package javabasic.project.objectOriented;

public class LottoResult {// 결과값을 토대로 등수를 출력해주는 클래스

	static void printResult() {

		System.out.println("입력하신 번호는");
		for (int i : paper.LOTTO_INPUT_NUM) {
			System.out.print(i + " ");
		}
		System.out.println("입니다");

		System.out.println("추첨 번호는");
		for (int i : macine.LOTTO_RANDOM_NUM) {
			System.out.print(i + " ");
		}
		System.out.println("이고");
		System.out.println("보너스 번호는 " + macine.LOTTO_LUCKY_NUM + " 입니다");

		System.out.print("당첨 결과는 ");
		if (computer.COR_NUM_COUNT == 15) {
			System.out.println("2등입니다");
		} else if (computer.COR_NUM_COUNT >= 10 && computer.COR_NUM_COUNT != 15) {
			System.out.println("8등입니다");
		} else {
			switch (computer.COR_NUM_COUNT) {
			case 6:
				System.out.println("1등입니다");
				break;
			case 5:
				System.out.println("3등입니다");
				break;
			case 4:
				System.out.println("4등입니다");
				break;
			case 3:
				System.out.println("5등입니다");
				break;
			case 2:
				System.out.println("6등입니다");
				break;
			case 1:
				System.out.println("7등입니다");
				break;
			case 0:
				System.out.println("8등입니다");
			}
		}
	}
}
