package javabasic.teamproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class SaveScoreFile {

	static List<User> readScoreFile() {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<User> userList = new ArrayList<User>();
		userList = null;
		try {

			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\Administrator\\git\\Java_KoreaIT_repo\\javabasic\\src\\javabasic\\teamproject\\ScoreToJSON.json"));

			String line = "";
			String jsonStr = "";
			
			while ((line = br.readLine()) != null) {
				jsonStr += line;
			}
			br.close();

			userList = gson.fromJson(jsonStr, new TypeToken<List<User>>() {
			}.getType());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return userList;
	} // readScoreFile

	static void writeScoreFile(List<User> userList) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(
					"C:\\Users\\Administrator\\git\\Java_KoreaIT_repo\\javabasic\\src\\javabasic\\teamproject\\ScoreToJSON.json"));
			bw.write(gson.toJson(userList));
			System.out.println(gson.toJson(userList));
			bw.flush();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		readScoreFile();
	}// 임시 메인

}// class
