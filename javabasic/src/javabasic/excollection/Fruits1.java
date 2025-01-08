package javabasic.excollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Fruits1 {

	public static void main(String[] args) {
		
		List<String> fruitList = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i<5; i++) {
			fruitList.add(scanner.next());
		}
		Iterator<String> it = fruitList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		scanner.close();
	}// main
}// class
