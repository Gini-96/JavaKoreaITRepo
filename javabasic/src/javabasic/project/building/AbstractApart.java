package javabasic.project.building;

public abstract class AbstractApart extends AbstractBuilding implements IApart{

	String playGroundNum; //놀이터의 수
	String areaPlayGround; //놀이터의 넓이
	
	public AbstractApart(int floor, int width, int length, int floorHigh, String playGroundNum, String areaPlayGround) {
		super(floor, width, length, floorHigh);
		this.playGroundNum = playGroundNum;
		this.areaPlayGround = areaPlayGround;
	}
	@Override
	public void madePlayGround() {
		
	}
	
	
}
