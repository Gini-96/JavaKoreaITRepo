package javabasic.exception;

public class ExceptionMain1 {

	public static void main(String[] args) {
		
		try {
			// 예외 발생 가능한 코드들
			// RuntimeException 중에 ArithmeticException 발생 (divide by zero)
			// 문법적으로 문제가 없어서 컴파일시에는 오류가 없음
			
			
			// ArithmeticException 이 발생하면 catch 안에 있는 Arithmetic 구문으로 예외객체를 전달
//			int i = 10/0;
			
			// NumberFormatException 이 발생하면 catch 안에 있는 IllegalArgument 구문으로 예외객체를 전달
			int i2 = Integer.parseInt("백");
			
		// RuntimeException 중에서 ArithmeticException 처리
		} catch (ArithmeticException ae) {// catch 가 여러개 일때는 위에서부터 하위예외 클래스
			// 발생한 예외를 처리하는 코드들
			System.out.println(ae.getClass().getName());
			ae.printStackTrace();
		// RuntimeException 중에서 IllegalArgumentException 처리
		} catch (IllegalArgumentException ie) {
			System.out.println(ie.getClass().getName());
			ie.printStackTrace();
		// RuntimeException 중에서 ArithmeticException이 아닌 예외 처리
		} catch (RuntimeException re) {
			System.out.println(re.getClass().getName());
			re.printStackTrace();
		// Exception 중에서 RuntimeException이 아닌 예외 처리
		} catch (Exception ex) {
			System.out.println(ex.getClass().getName());
			ex.printStackTrace();
		} finally {// 선택사항
			// 예외가 발생하든 안하든 처리할 코드들
			System.out.println("예외발생 여부에 상관없이 이 코드는 수행됩니다");
		}
		
		
		
		
		
		
		
		
		
		
	}// main
}// class
