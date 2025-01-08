package javabasic.project.building;

import java.util.Date;

public abstract class AbstractBuilding implements IBuilding, IApart, IFactory, IVilla, ISchool{

	String name; // 건물 이름
	String company; // 건축 회사
	Date date; // 건축 일자
	boolean livingSpace; //주거공간 유무\
	int floor; // 층수
	int width; //건물의 가로 길이
	int length; //건물의 세로 길이
	int floorHigh; //층당 높이
	
	
	
	public AbstractBuilding(int floor, int width, int length, int floorHigh) {
		super();
		this.floor = floor;
		this.width = width;
		this.length = length;
		this.floorHigh = floorHigh;
	}
	
	@Override
	public abstract void madeBuilding();
	
	@Override
	public void turnOn() {
		System.out.println("전기가 들어옵니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("전기가 나갑니다.");
	}
	
	
	
}
