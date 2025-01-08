package javabasic.oop;

import java.sql.Timestamp;
import java.util.Date;

public class RobotMain {

	public static void main(String[] args) {
		
		// Robot을 생성할 수 있는 RobotFactory 생성
		RobotFactory robotFactory = new RobotFactory();
		
		// RobotFactory를 통해서 Robot을 생성
		// System.currentTimeMillis()
		// UNIX타입 (전산학 원년시간, 1970년 1월 1일 0시 0분 0초 0밀리초 부터 현재까지
		// 밀리초마다 1씩 센 값을 반환
		
		System.out.println(System.currentTimeMillis());
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		
		robotFactory.createRobot("건담", "건담주식회사", 
				new Timestamp(System.currentTimeMillis()), 150);

		createRobot(robotFactory, "태권브이", "태권브이주식회사",
				new Timestamp(System.currentTimeMillis()), 100);
		
		robotFactory.createRobot("또봇", "또봇주식회사", 
				new Timestamp(System.currentTimeMillis()), 50);
		
		robotFactory.createRobot("건담", "건담주식회사", 
				new Timestamp(System.currentTimeMillis()), 150);
		
		robotFactory.createRobot("또봇", "또봇주식회사", 
				new Timestamp(System.currentTimeMillis()), 50);
		
		
		
		
	}//main

	private static void createRobot(RobotFactory robotFactory, 
			String name, String company, Timestamp mfd, int weight) {
		robotFactory.createRobot(name, company, mfd, weight);
	}
}//class
