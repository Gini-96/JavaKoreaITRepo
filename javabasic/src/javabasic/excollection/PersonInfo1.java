package javabasic.excollection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonInfo1 {

	public static void main(String[] args) {
		Map<String, String> personMap = new HashMap<String, String>();
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i<3; i++) {
			String input = scanner.next();
			String name = input.substring(0, input.indexOf(','));
			String age = input.substring(input.indexOf(',')+1);
			personMap.put(name, age);
		}
		
		Set<Map.Entry<String, String>> entrySet = personMap.entrySet();
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.printf("%s은(는) %s살 입니다\n",entry.getKey(),entry.getValue());
		}
		
		
		
		
		scanner.close();
	}// main
	
}// class
