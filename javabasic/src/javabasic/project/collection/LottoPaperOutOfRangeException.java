package javabasic.project.collection;

public class LottoPaperOutOfRangeException extends Exception {

	@Override
	public String toString() {
		return "범위에 맞는 번호를 다시 입력해 주세요";
	}
}
