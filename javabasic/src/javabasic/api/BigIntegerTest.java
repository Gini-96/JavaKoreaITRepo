package javabasic.api;

import java.math.BigInteger;

// BigInteger : long의 범위를 넘는 크거나 작은 정수
// BigDecimal : double 의 범위를 넘는 크거나 작은 실수

public class BigIntegerTest {
	public static void main(String[] args) {
		
		//-9,223,372,036,854,775,808부터 9,223,372,036,854,775,807까지
		BigInteger bi1 = new BigInteger("922337203685477580711111111111111111");
		BigInteger bi2 = new BigInteger("822337203685477580711111111111111111222222222222");
		
		
		BigInteger bi3 = bi1.add(bi2); // 덧셈
		System.out.println(bi3);
		
		System.out.println(bi1.subtract(bi2));
		System.out.println(bi1.multiply(bi2));
		System.out.println(bi2.divide(bi1));
		
		BigInteger bi4 = bi1.max(bi2);
		System.out.println(bi4);
		
		BigInteger bi5 = bi1.min(bi2);
		System.out.println(bi5);
		
	}// main
}// class
