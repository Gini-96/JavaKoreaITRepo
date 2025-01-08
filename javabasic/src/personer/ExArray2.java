package personer;

public class ExArray2 {

	public static void main(String[] args) {
	
		String[][] strArr = {
				{"홍길동", "강감찬", "이순신"},
				{"A", "B", "C"}
		};
		
		int strArrLength = strArr.length;
		int strArr0Length = strArr[0].length;
		for (int i = 0; i<strArrLength; i++) {
			for (int j = 0; j<strArr0Length; j++) {
				System.out.println(strArr[i][j]);
			}
		}
		
	}//main
	
}//class
