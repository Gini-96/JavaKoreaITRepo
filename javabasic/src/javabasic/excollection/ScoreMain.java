package javabasic.excollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ScoreMain {
	
	public static void main(String[] args) {
		seeStudentScore();
		
	}// main
	
	// 기능적으로는 맞으나 Student 와 Score class 사용하지 않아 객체 지향 적으로 맞지 않음
	static void seeStudentScore () {
		List<String> studentScore = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i<3; i++) {
			String score = scanner.next();
			// 입력 된 수가 적을 경우 이것도 괜찮아 보이는데 수가 많아 졌을때에 결과 값이 너무 안좋아 질거 같기도
//			studentScore = studentScore.subList(0, studentScore.indexOf(","));
			StringTokenizer st = new StringTokenizer(score,",");
			while (st.hasMoreTokens()) {
				studentScore.add(st.nextToken());
			}
			
			System.out.printf("%s은 국어 %d점 영어 %d점 수학 %d점 총점 %d점입니다.", studentScore.get(0),
					Integer.parseInt(studentScore.get(1)),
					Integer.parseInt(studentScore.get(2)),
					Integer.parseInt(studentScore.get(3)),
					Integer.parseInt(studentScore.get(1))+Integer.parseInt(studentScore.get(2))+Integer.parseInt(studentScore.get(3)));
		}
		scanner.close();
	}
	
	
	
}// class
