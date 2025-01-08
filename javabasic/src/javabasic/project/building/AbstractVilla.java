package javabasic.project.building;

public abstract class AbstractVilla extends AbstractBuilding{

	boolean roofTopRoom; //옥탑방 유무
	String parking; // 주차장 생성
	
	public AbstractVilla(int floor, int width, int length, int floorHigh, boolean roofTopRoom, String parking) {
		super(floor, width, length, floorHigh);
		this.roofTopRoom = roofTopRoom;
		this.parking = parking;
	}

	@Override
	public void madeParking() {
		
	}
}
