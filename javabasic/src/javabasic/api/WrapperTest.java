package javabasic.api;

// Wrapper 클래스
// 기본타입의 값을 가지고 있는 참조타입
// Byte, Short, Integer, Long, Float, Double, Character, Boolean

public class WrapperTest {
	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE); // int 최대값
		System.out.println(Integer.MIN_VALUE); // int 최소값
		
		System.out.println(Integer.SIZE); // bit 크기
		
		Integer i1 = 5; // wrapping (기본타입을 참조타입으로)
		Integer i2 = 10;
		
		System.out.println(Integer.compare(i1, i2)); // 뒤의 값이 더 크므로 -1이 출력됨
		System.out.println(Integer.compare(i2, i1)); // 앞의 값이 더 크므로 1이 출력됨
		
		int i3 = i1.intValue(); // unwrapping (참조타입을 기본타입으로)
		System.out.println(i3);
		
		System.out.println(Integer.max(i1, i2)); // 최대값 출력
		System.out.println(Integer.min(i1, i2)); // 최소값 출력
		
		int i4 = Integer.parseInt("100"); // 문자열을 int 로
		System.out.println(i4);
		
		// 100 자리에 백을 적으면 숫자가 아닌 문자로 인식하기 때문에 NumberFormathException 에러가 발생
		
		System.out.println(Integer.toBinaryString(500));
		System.out.println(Integer.toHexString(500));
		System.out.println(Integer.toOctalString(500));
		
		Integer i6 = Integer.valueOf(5); // wrapping 기본타입을 참조타입으로
		
		
	}// main
}// class
