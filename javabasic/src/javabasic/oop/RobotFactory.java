package javabasic.oop;

import java.sql.Timestamp;

//역할 : Robot 생성
public class RobotFactory {

	// static member variable
	// 클래스 로딩 타임에 메모리에 생성되고 자동 초기화됨
	private static int count; // 생산수량
	
	public Robot createRobot(String name, String company, Timestamp mfd, int weight) {
		System.out.println(name + "로봇이 생성 되었습니다");
		System.out.println("총 생산된 로봇의 수량은" + ++count + "대 입니다");
		return new Robot(name, company, mfd, weight);
	}
	
	public static int getCount() {
		return count;
	}
	
	
}//class
