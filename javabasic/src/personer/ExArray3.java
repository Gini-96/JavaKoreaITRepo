package personer;

public class ExArray3 {

	public static void main(String[] args) {

		/*
		 * String[] strArr = {"홍길동", "강감찬", "이순신"}; int[][] intArr = { {90,80,70},
		 * {80,70,50}, {70,60,40} }; int intArrLength = intArr.length; int intArr0Length
		 * = intArr[0].length;
		 * 
		 * for (int i = 0; i<intArrLength; i++) {//행의 수만큼 반복 for (int j = 0;
		 * j<intArr0Length; j++) {//열의 수만큼 반복 System.out.println(intArr[i][j]); }
		 * System.out.println(); }
		 */

		//내꺼
		String[][] scoreArr = { 
				{ "홍길동", "90", "80", "70" }, 
				{ "강감찬", "80", "70", "60" }, 
				{ "홍길동", "70", "50", "40" } 
			};

		int[] totalArr = { 0, 0, 0 };

		int scoreArrLength = scoreArr.length;
		int scoreArr0Length = scoreArr[0].length;
		int totalArrLength = totalArr.length;
		for (int i = 0; i < scoreArrLength; i++) {
			for (int j = 0; j < scoreArr0Length; j++) {
				if (j != 0) {
					int l = Integer.parseInt(scoreArr[i][j]);
					totalArr[i] += l;//[]안에 i를 넣으면 되는것을 알지 못해서 시간이 오래 걸림
				}

				System.out.println(scoreArr[i][j]);
			}
			System.out.println(totalArr[i]);// 위 주석과 동일
			System.out.println();
		}
		//여기부터는 강사님 꺼를 본 후에 출력을 시작함
		for (int i=0; i<totalArrLength; i++) {
			if (totalArr[i]>=200) {
				System.out.println(scoreArr[i][0] + "학생의 총점은" + totalArr[i] + "입니다");
			}
		}
		
		//강사님꺼
		// if (j != 0) {
		//int l = Integer.parseInt(scoreArr[i][j]);
		//totalArr[i] += l;
		//}
		//부분을
		//if (j>0) {
		//totalArr[i] += Integer.perseInt(scoreArr[i][j]);
		//}
		//로 간단한 코드로 변환 ( 불필요한 코드 길이를 줄임)
		
	}// main
}// class
