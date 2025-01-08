package javabasic.excollection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Fruits2 {

	public static void main(String[] args) {

		Set<String> fruitSet = new HashSet<String>();
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			if (fruitSet.add(scanner.nextLine()) == false) {
				try {
					throw new FruitsException();
				} catch (FruitsException fe) {
					System.out.println(fe);
				} finally {
					i--;
				}
			}
		}
		scanner.close();
		Iterator<String> it = fruitSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}// main

}// class
