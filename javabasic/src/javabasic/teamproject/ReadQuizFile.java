package javabasic.teamproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// 문제 파일을 불러오고 제공하는 클래스
public class ReadQuizFile {

	static List<Quiz> readQuizFile () {
		
		// JSON to List 를 위한 gson 생성
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// 총 5개의 퀴즈를 quizList에 추가하기 위한 새 ArrayList 생성
		List<Quiz> quizList = new ArrayList<Quiz>();
		
		try {
			
			// 파일 내용을 읽어 오기 위한 Reader 와 파일 경로 지정
			BufferedReader br = new BufferedReader(
					new FileReader("C:\\Users\\Administrator\\git\\Java_KoreaIT_repo\\javabasic\\src\\javabasic\\teamproject\\QuiztoJSON.json"));
			
			// 파일에서 읽은 내용을 저장할 변수 선언
			String line="";
			String jsonStr="";
			
			// 파일을 한 줄씩 읽어 들여 jsonStr에 저장
			while ((line = br.readLine())!=null) {
				jsonStr +=line;
			}
			
			// JSON 문자열을 List<Quiz> 타입으로 변환하여 totalquizList에 저장
			List<Quiz> totalquizList = gson.fromJson(jsonStr, new TypeToken<List<Quiz>>() {}.getType());
			br.close();
			
			// 총 문제중 랜덤으로 출제를 하기 위한 순서 랜덤으로 섞음
			Collections.shuffle(totalquizList);
			
			
			// 랜덤으로 섞인 totalquizList 에서 첫 5개의 퀴즈를 quizList에 추가
			for (int i = 0; i < 5; i++) {
				quizList.add(i, totalquizList.get(i));
				Collections.shuffle(quizList.get(i).getHints());
			}
		
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return quizList;
		
	}// readQuizFile
	
	public static void main(String[] args) {
		
		List<Quiz> list = readQuizFile();
		for (Quiz quiz : list) {
			System.out.println(quiz);
		}
		
	}// 임시 메인

}// class
