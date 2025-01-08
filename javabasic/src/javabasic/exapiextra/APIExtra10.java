package javabasic.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class APIExtra10 {//미국독립선언서(americadoi.txt) 파일내에서 영단어 중 길이가 가장 긴 단어부터 가장 짧은 단어를 순서대로 개수와 함께 출력

	public static void main(String[] args) {
		
	}// main
	
	static void print() {
		
		// 공백과 영어를 제외한 기호, 숫자, 한글을 모두 제외
		// 공백 기준으로 영어 단어를 토큰화
		String line = getText();
		
		
	}
	
	private static String getText() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\git\\Java_KoreaIT_repo\\javabasic\\src\\javabasic\\exapiextra\\americadoi.txt")));
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
}// class
