package javabasic.project.collection;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javabasic.excollection.FruitsException;

public class LottoPaperCollection {

	// 입력을 0,0,0,0,0,0 으로 받고
	// 토크나이즈를 사용하여 하나씩 저장하며 예외 처리
	// 숫자가 아니면 예외
	// 6개를 넘어가면 예외
	// 범위를 넘어가면 예외
	// 중복된 숫자가 있으면 예외

	static void inputNum() {
		Set<Integer> inputNum = new HashSet<Integer>();
		Scanner scanner = new Scanner(System.in);
		
		try {
			if (inputNum.add(scanner.nextInt()) == false) 
				throw new LottoPaperDupliException();
			else if () == false) 
				throw new LottoPaperOutOfRangeException();
		} catch (LottoPaperDupliException lpde) {
			System.out.println(lpde);
		} catch (LottoPaperOutOfRangeException lpore) {
			System.out.println(lpore);
		}
		scanner.close();
		}

}// class
