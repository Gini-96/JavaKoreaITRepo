package javabasic.exapiextra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class APIExtra9 {// 미국독립선언문(americadoi.txt) 파일 내의 한글, 영문, 기호의 개수를 출력
	public static void main(String[] args) {
		print();
	}// main
	
	static void print() {
		char[] chArr = getText().toCharArray();
		
		int engCount = 0;
		int symCount = 0;
		int korCount = 0;
		
		for (char ch : chArr) {
			String str = String.valueOf(ch);
			if (str.matches("[가-힣]")) {
				korCount++;
			}
			else if (str.matches("[a-zA-Z]")) {
				engCount++;
			}
			else if (str.matches("[\\W_]")) {
				symCount++;
			}
		}
		System.out.printf("한글:%d개, 영문%d개, 기호%d개",
				korCount,engCount,symCount);
		
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
