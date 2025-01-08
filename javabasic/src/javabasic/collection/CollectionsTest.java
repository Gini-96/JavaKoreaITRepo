package javabasic.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

public class CollectionsTest {
	
	public static void main(String[] args) {
		
		// static 상수들
		System.out.println(Collections.EMPTY_LIST); // 요소가 없는 리스트
		System.out.println(Collections.EMPTY_SET); // 요소가 없는 셋
		System.out.println(Collections.EMPTY_MAP); // 요소가 없는 맵
		
		System.out.println(Collections.emptyList());
		System.out.println(Collections.emptySet());
		System.out.println(Collections.emptyMap());
		System.out.println(Collections.emptyIterator());
		
		List<String> nameList = new ArrayList<String>();
		nameList.add("홍길동");
		nameList.add("강감찬");
		nameList.add("이순신");
		
		// 컬렉션에 요소 추가
		// varargs (가변인자) : 1개 이상의 인자
		Collections.addAll(nameList, "장보고");
		Collections.addAll(nameList, "장보고", "최영");
		System.out.println(nameList);
		
		// 컬렉션 복사
		// 비어있는 컬렉션에 복사하면 IndexOutOfBoundsException 발생
		// 컬렉션을 만들때에 사이즈를 동일하게 설정해두면 카피 가능
		List<String> copyList 
			= new ArrayList<String>(Collections.nCopies(nameList.size(), null));
		Collections.copy(copyList, nameList);
		System.out.println(copyList);
		
		List<String> copyList2
			= new ArrayList<String>(Collections.nCopies(nameList.size(), null));
		Collections.fill(copyList2, "김유신");
		System.out.println(copyList2);
		
		// 컬렉션 열거자 (java 1.0 버전부터 있었으며 Iterator 의 전 버전, 호환성 때문에 아직 사용하는 곳이 있음)
		Enumeration<String> en = Collections.enumeration(nameList);
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
		// 컬렉션 요소 대체
		Collections.replaceAll(copyList2, "김유신", "최영");
		System.out.println(copyList2);
		
		// 컬렉션 요소 순서 180도 뒤집음
		Collections.reverse(nameList);
		System.out.println(nameList);
		
		Collections.shuffle(nameList);
		System.out.println(nameList);
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(5);
		intList.add(10);
		intList.add(1);
		intList.add(6);
		intList.add(9);
		
		// 컬렉션 요소 정렬
		// sort(정렬할 컬렉션, Comparator 구현한 익명 클래스)
		// 익명클래스 에서는 Comparator 의 compare()를 오버라이딩
		Collections.sort(intList, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				
				return i1-i2;
			}
		});
		System.out.println(intList);
		
		Collections.reverse(intList);
		System.out.println(intList);
		
	}// main

}// class
