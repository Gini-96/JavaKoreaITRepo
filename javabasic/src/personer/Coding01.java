package personer;

public class Coding01 {

	static public int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++)
			if (n % i == 0) {
				answer += i;
			}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(12));
	}
}
