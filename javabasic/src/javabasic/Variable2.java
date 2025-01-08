package javabasic;

public class Variable2 {

	// 1.static 변수
	// 1) 클래스로딩타임에 JVM이 관리하는 Method Area 라는 메모리 영역에 생김
	// 2) 객체 생성없이 사용할 수 있는 변수
	// 3) 클래스의 모든 객체들이 값을 공유하는 변수
	
	// static member variable
	static int si = 1;
	
	// 2. non static 변수
	// 1) 실행타임에 JVM이 관리하는 Heap Area라는 메모리 영역에 생김
	// 2) 객체가 생성되면 객체마다 가지게 되는 변수 = 객체마다 변수의 값을 달리할 수 있음
	
	// non static member variable
	int nsi = 2; 
	
	// static member method
	public static void main(String[] args) { 
		
		Variable2 v2_1 = new Variable2();
		Variable2 v2_2 = new Variable2();
		System.out.println(v2_1.si); //1
		System.out.println(v2_2.si); //1
		
		// static 변수는 메모리에 한번만 만들어 지고 모든 객체들이 값을 공유함
		v2_1.si = 2;
		System.out.println(v2_1.si); //2
		System.out.println(v2_2.si); //2
		
		System.out.println(v2_1.nsi); //2
		System.out.println(v2_2.nsi); //2
		
		// non static 변수는 객체마다 하나씩 가지게 되는 변수
		v2_1.nsi = 5;
		System.out.println(v2_1.nsi); //5
		System.out.println(v2_2.nsi); //2
		
		// main메소드의 지역변수
		// main메소드가 호출되면 메모리에 생겼다가 main메소드가 종료되면 소멸
		int li = 3;
		
		
	}
	
	// non static member method (스태틱은 아니지만 메소드기 때문에 Method Area 때 올라옴)
	public int add(int i, int j) {
		//add 메소드의 지역변수
		int sum = i + j;
		return sum;
		
	}
}