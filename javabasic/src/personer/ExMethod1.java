package personer;

public class ExMethod1 {

	public static void main(String[] args) {
		System.out.println(seeBiggerInt(5, 1));
	}//main
	static int seeBiggerInt(int a, int b) {
		if (a>b) {
			return a;
		}
		else {
			return b;
		}
	}
}//class
