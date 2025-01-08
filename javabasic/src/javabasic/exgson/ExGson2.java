package javabasic.exgson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//개인실습 2)
//https://jsonplaceholder.typicode.com/users
//https://jsonplaceholder.typicode.com/todos
//사용자별 todo의 전체개수와 완료한 todo의 개수를 아래 형식으로 todocount.log 파일에 저장
//파일 출력 형식 : 사용자명 [전체todo수:00개, 완료한 todo수:00개]

public class ExGson2 {

	public static void main(String[] args) {
		
		String usersUri = "https://jsonplaceholder.typicode.com/users";
		String todosUri = "https://jsonplaceholder.typicode.com/todos";
		File file = new File("D:\\embededk\\files\\todocount.log");
		PrintWriter pw = null;
		try {
			
			URL usersUrl = new URI(usersUri).toURL();
			URL todosUrl = new URI(todosUri).toURL();
			
			URLConnection usersConn = usersUrl.openConnection();
			URLConnection todosConn = todosUrl.openConnection();
			
			BufferedReader usersBr = new BufferedReader(new InputStreamReader(usersConn.getInputStream()));
			BufferedReader todosBr = new BufferedReader(new InputStreamReader(todosConn.getInputStream()));
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();

			String usersTotalLine = "";
			String todosTotalLine = "";
			String line = "";
			
			while ((line=usersBr.readLine())!=null) {
				usersTotalLine += line;
			}
			List<Users> usersList = gson.fromJson(usersTotalLine, new TypeToken<List<Users>>() {}.getType());
			
			while ((line=todosBr.readLine())!=null) {
				todosTotalLine += line;
			}
			List<Todos> todosList = gson.fromJson(todosTotalLine, new TypeToken<List<Todos>>() {}.getType());
			
			int usersListSize = usersList.size();
			int todosListSize = todosList.size();
			
			for (int i=0; i<usersListSize;i++) {
				for (int j=0; j<todosListSize; j++) {
					int totalTodoCount = 0;
					int compTodoCount = 0;
					if (usersList.get(i).getId().equals(todosList.get(j).getUserId())) {
						totalTodoCount+=1;
					}
					if (usersList.get(i).getId().equals(todosList.get(j).getUserId()) 
							&& todosList.get(j).isCompleted()==true) {
						compTodoCount+=1;
					}
					pw = new PrintWriter(file);
					pw.printf("%s [전체 todo 개수:%d개, 완료한 todo 개수:%d개"
							, usersList.get(i).getName()
							, totalTodoCount, compTodoCount);
				}
			}
			pw.flush();
			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		}
		
		
		
		
	}// main
	
}// class
