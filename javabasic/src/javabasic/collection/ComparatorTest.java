package javabasic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

	public static void main(String[] args) {

		// Comparator 타입의 객체 생성
		Comparator<Integer> intCom = new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				return i1 - i2;
			}
		};

		List<Integer> intList = new ArrayList<Integer>();
		intList.add(3);
		intList.add(10);
		intList.add(2);
		intList.add(9);
		intList.add(5);

		// 컬렉션 정렬
		Collections.sort(intList, intCom);
		System.out.println(intList);

		Collections.reverse(intList);
		System.out.println(intList);

		Comparator<String> strCom = new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {
				return str1.length() - str2.length();

			}
		};

		List<String> strList = new ArrayList<String>();
		strList.add("hi");
		strList.add("hello");
		strList.add("java");
		strList.add("programing");
		strList.add("a");

		Collections.sort(strList, strCom);
		System.out.println(strList);

		Collections.reverse(strList);
		System.out.println(strList);

		class Person {
			String name;
			int age;

			Person(String name, int age) {
				this.name = name;
				this.age = age;
			}

			@Override
			public String toString() {
				return name + ":" + age;
			}
		}

		List<Person> personList = new ArrayList<Person>();

		personList.add(new Person("홍길동", 90));
		personList.add(new Person("강감찬", 10));
		personList.add(new Person("이순신", 30));
		personList.add(new Person("최영", 100));
		personList.add(new Person("권율", 40));
		System.out.println(personList);

		// 각 사람의 나이에 대해서 오름차순 내림차순 정렬

		Comparator<Person> personCom = new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {

				return p1.age - p2.age;
			}
		};

		Collections.sort(personList, personCom);
		System.out.println(personList);

		Collections.reverse(personList);
		System.out.println(personList);

		// 1) 아래 리스트를 나이순으로 내림차순 정렬하세요
		List<String> ssnList = new ArrayList<String>();
		ssnList.add("980000-1234567");
		ssnList.add("000000-1234567");
		ssnList.add("050000-1234567");
		ssnList.add("880000-1234567");
		ssnList.add("990000-1234567");

		Comparator<String> ssnCom = new Comparator<String>() {

			@Override
			public int compare(String str1, String str2) {

				return Integer
						.parseInt(str2.startsWith("0") ? "20" + str2.substring(0, 2) : "19" + str2.substring(0, 2))
						- Integer.parseInt(
								str1.startsWith("0") ? "20" + str1.substring(0, 2) : "19" + str1.substring(0, 2));
			}
		};

		Collections.sort(ssnList, ssnCom);
		System.out.println(ssnList);

		// 2 아래 리스트를 각 학생의 성적 총합 순으로 내림차순 정렬하세요
		class Score {
			int kor;
			int eng;

			Score(int kor, int eng) {
				this.kor = kor;
				this.eng = eng;
			}
		}
		class Student {
			String name;
			Score score;

			Student(String name, Score score) {// 이 칸에 총합을 계산하는 int sum 만 추가해서도 사용가능
				this.name = name;
				this.score = score;
			}

			@Override
			public String toString() {
				return name + "의 국어 점수: " + score.kor + ", 영어 점수: " + score.eng + ", 총점: " + (score.kor + score.eng)
						+ "\n";
			}
		}
		List<Student> stdList = new ArrayList<Student>();
		stdList.add(new Student("홍길동", new Score(70, 50)));
		stdList.add(new Student("강감찬", new Score(100, 100)));
		stdList.add(new Student("이순신", new Score(90, 70)));
		stdList.add(new Student("장보고", new Score(40, 90)));
		stdList.add(new Student("최영", new Score(80, 60)));

		System.out.println(stdList);

		Comparator<Student> stdCom = new Comparator<Student>() {
			public int compare(Student std1, Student std2) {

				return (std2.score.kor + std2.score.eng) - (std1.score.kor + std1.score.eng);
			};
		};

		Collections.sort(stdList, stdCom);
		System.out.println(stdList);

		// 3) 아래 리스트를 이름순으로 1차 오름차순 정렬하고 가격순으로 2차 내림차순 정렬
		class Product {
			String name;
			int price;

			Product(String name, int price) {
				this.name = name;
				this.price = price;
			}

			@Override
			public String toString() {
				return name + ":" + price + "\n";
			}
		}
		List<Product> prodList = new ArrayList<Product>();
		prodList.add(new Product("피씨", 100));
		prodList.add(new Product("모니터", 100));
		prodList.add(new Product("마우스", 100));
		prodList.add(new Product("키보드", 100));
		prodList.add(new Product("스피커", 100));
		prodList.add(new Product("피씨", 200));
		prodList.add(new Product("모니터", 200));
		prodList.add(new Product("마우스", 200));
		prodList.add(new Product("키보드", 200));
		prodList.add(new Product("스피커", 200));

		// 앞에 하나만 비교 하는 거라 첫단어가 다 동일할경우 비교 할수가 없음
//		Comparator<Product> prodNameCom = new Comparator<Product>() {
//			public int compare(Product n1, Product n2) {
//				return ((int)n1.name.charAt(0))-((int)n2.name.charAt(0));
//			};
//		};

		Comparator<Product> prodNameCom = new Comparator<Product>() {

			public int compare(Product n1, Product n2) {
				return n1.name.compareTo(n2.name);
			}
		};

		System.out.println();
		Comparator<Product> prodPriceCom = new Comparator<Product>() {
			public int compare(Product p1, Product p2) {
				if (p1.name.equals(p2.name)) {
					return p2.price - p1.price;
				} else {
					return 0;
				}
			}
		};

		Collections.sort(prodList, prodNameCom);
		System.out.println(prodList);
		
		Collections.sort(prodList, prodPriceCom);
		System.out.println(prodList);

	}// main

}// class
