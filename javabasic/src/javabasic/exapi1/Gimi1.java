package javabasic.exapi1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Gimi1 {
	
	public static void main(String[] args) {
		
		// 파일의 전체 텍스트를 저장
		String gimi = getText();
		
		// '독립' 문자열 인덱스 탐색을 위한 시작 인덱스
		int idx = -1;
		// '독립' 문자열의 발생횟수를 저장할 변수
		int count = 0;
		
		// idx=gini.indexOf("독립", idx+1) -> 0번 인덱스 부터 "독립"의 인덱스를 찾아서 idx에 저장
		while((idx=gimi.indexOf("독립", idx+1)) >= 0) {
			count++;
			System.out.println("'독립'의 "+ count + "번째 인덱스 : " + idx + "\n");
		}
		
		System.out.println("'독립' 이라는 문자열은 " + count + "번 나옵니다\n");
		
		// "." 문자열을 ".\n"로 대체
		// \\. -> 정규표현식의 패턴문자열(정규표현식에서 . 문자는 문자하나를 나타냄)
		System.out.println(gimi.replaceAll("\\.", ".\n"));
		
	} // main
	
	private static String getText() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\git\\Java_KoreaIT_repo\\javabasic\\src\\javabasic\\exapi1\\gimi.txt")));
			String line = "";
			String gimiTxt = "";
			while ((line=br.readLine())!=null) {
				gimiTxt += line;
			}
			br.close();
			return gimiTxt;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
			return null;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}
	}
	

} // class


















