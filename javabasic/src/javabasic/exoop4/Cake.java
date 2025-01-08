package javabasic.exoop4;

public class Cake {

	private String name;
	
	public Cake() {
	}

	public Cake(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}





	public void make() {
		System.out.println("케이크가 만들어 졌습니다");
	}
}// class
