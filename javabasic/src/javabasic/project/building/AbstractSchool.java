package javabasic.project.building;

public abstract class AbstractSchool extends AbstractBuilding{

	String areaGround; //운동장의 넓이
	int multiPurposeRoom; // 다목적실 수
	
	public AbstractSchool(int floor, int width, int length, int floorHigh, String areaGround, int multiPurposeRoom) {
		super(floor, width, length, floorHigh);
		this.areaGround = areaGround;
		this.multiPurposeRoom = multiPurposeRoom;
	}

	@Override
	public void madeMultiPurposeRoom() {
		
	}
}
