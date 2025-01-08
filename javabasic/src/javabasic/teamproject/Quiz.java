package javabasic.teamproject;

import java.util.List;

// 문제 출제를 위한 JAVA Bean
public class Quiz {
	
	
	private String answer;//정답
 	private List<String> hints;
 	
 	public Quiz() {
 		
 	}

	public Quiz(String answer, List<String> hints) {
		super();
		this.answer = answer;
		this.hints = hints;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public List<String> getHints() {
		return hints;
	}

	public void setHints(List<String> hints) {
		this.hints = hints;
	}

	@Override
	public String toString() {
		return "Quiz [answer=" + answer + ", hints=" + hints + "]";
	}

	
}
