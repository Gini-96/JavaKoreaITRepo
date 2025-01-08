package personer;

public class ExLoopStatement2 {

	public static void main(String[] args) {

		// 1 강사님이랑 같이
		System.out.println("1");
		for (int i = 0; i < 5; i++) { // 줄의 수 i
			for (int j = 0; j < i + 1; j++) { // 별의 수 j
				System.out.print("*");
			}
			System.out.println();
		}

		// 2 내꺼
		System.out.println("2");
		for (int i = 0; i < 5; i++) { // 줄의 수 i
			for (int j = 0; j < 5 - i; j++) { // 별의 수 j
				System.out.print("*");
			}
			System.out.println();
		}

		// 3 강사님이랑 같이
		System.out.println("3");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < 5 - i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 4 내꺼
		// 4-1
		System.out.println("4-1");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 0; k < i * 2 + 1; k = k + 1) {
				System.out.print("*");
			}
			for (int l = 0; l < 4 - i; l++) {
				System.out.print(" ");
			}

			System.out.println();

		}
		// 4-2
		System.out.println("4-2");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("*");
			}
			System.out.println();

		}
		// 4 강사님꺼
		System.out.println("4 - 강사님꺼");
		for (int i = 0; i < 5; i++) { // 줄의 수
			for (int j = 4 - i; j > 0; j--) { // 공백의 수
				System.out.print("o");
			}
			for (int j = 0; j <= 2 * i; j++) { // 별의 수
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}

		System.out.println();

		// 5 내꺼
		// 5-1
		System.out.println("5-1");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 1; j++) {
				System.out.print("*");
			}
			for (int k = 0; k < 3; k++) {
				if (i % 4 == 0) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			for (int l = 0; l < 1; l++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 5-2
		System.out.println("5-2");
		for (int i = 0; i < 5; i++) {
			if (i % 4 == 0) {
				for (int j = 0; j < 5; j++) {
					System.out.print("*");
				}
			} else {
				for (int k = 0; k < 1; k++) {
					System.out.print("*");
				}
				for (int l = 0; l < 3; l++) {
					System.out.print(" ");
				}
				for (int m = 0; m < 1; m++) {
					System.out.print("*");
				}
			}

			System.out.println();
		}
		// 5-3
		System.out.println("5-3");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 4 != 0 && j % 4 != 0) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		// 6 내꺼
		System.out.println("6");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 4 == 0 && j % 4 == 0 || i % 2 == 1 && j % 2 == 1 || i % 4 == 2 && j % 4 == 2) { // i==j ||
																										// 4-i==j 순서대로
																										// 증가,감소하는거기 때문에
																										// 이렇게도 가능
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		// 7 내꺼
		System.out.println("7");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i % 2 == 1 && j % 4 == 2 || i % 4 == 2 && j % 2 == 1) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}

		// Extra 실습
		// 별찍기
		//   *
		//  ***
		// *****
		//  ***
		//   *
		final int LINE_LENGTH = 19;
		final int MIDDLE_OF_LINE_LENGTH = LINE_LENGTH/2;
		System.out.println(MIDDLE_OF_LINE_LENGTH);
		System.out.println("Extra 실습");
		for (int i = 0; i < LINE_LENGTH; i++) {
			for (int j = Math.abs(MIDDLE_OF_LINE_LENGTH-i); j > 0; j--) { // 공백의 수
				System.out.print("o");
			}
			for (int j = LINE_LENGTH - 2*Math.abs(MIDDLE_OF_LINE_LENGTH-i); j > 0; j--) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("Extra 실습-2");
		
		String[][] starDiamond = {
				{"","","","",""},
				{"","","","",""},
				{"","","","",""},
				{"","","","",""},
				{"","","","",""}
		};
		
		int starDiamondLength = starDiamond.length;
		int starDiamond0Length = starDiamond[0].length;
		int middleOfStarDiamondLength = starDiamondLength/2;
		
		for (int i = 0; i < starDiamondLength; i++) {
			for (int j = Math.abs(middleOfStarDiamondLength-i); j > 0; j--) { // 공백의 수
				System.out.print("o");
			}
			for (int j = starDiamond0Length - 2*Math.abs(middleOfStarDiamondLength-i); j > 0; j--) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}
		
		
	} // main

} // class
