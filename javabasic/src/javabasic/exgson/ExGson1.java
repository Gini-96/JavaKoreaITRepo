package javabasic.exgson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// 개인실습 1)
// https://jsonplaceholder.typicode.com/posts 에서 JSON 문자열을 수신하여
// List 에 저장한 후 id 값에 대해 내림차순 정렬하서 출력

public class ExGson1 {

	public static void main(String[] args) {
		
		String jsonUrl = "https://jsonplaceholder.typicode.com/posts";
		
		try {
			URL url = new URI(jsonUrl).toURL();
			
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String totalLine = "";
			String line = "";
			
			while ((line=br.readLine())!=null) {
				totalLine += line;
			}
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			List<Post> postList = gson.fromJson(totalLine, new TypeToken<List<Post>>() {}.getType());
//			Comparator<Post> idCom = new Comparator<Post>() {
//				
//				@Override
//				public int compare(Post i1, Post i2) {
//					return Integer.parseInt(i2.getId()) - Integer.parseInt(i1.getId());
//				}
//			};
//			
//			Collections.sort(postList, idCom);
			Collections.sort(postList, new Comparator<Post>() {
	            @Override
	            public int compare(Post post1, Post post2) {
	               return Integer.parseInt(post2.getId()) 
	                     - Integer.parseInt(post1.getId());
	            }
	         });
			int postListSize = postList.size();
			for (int i=0;i<postListSize;i++) {
				System.out.println(postList.get(i));
			}
			
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch (URISyntaxException urise) {
			urise.printStackTrace();
		}
		
		
		
		
		
		
	}// main
	
	
	
}// class
