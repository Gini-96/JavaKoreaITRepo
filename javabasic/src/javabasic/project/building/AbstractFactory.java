package javabasic.project.building;

public abstract class AbstractFactory extends BuildingAdapter{

	int mashineNum; // 보유 기계수
	int chimneyNum; //굴뚝의 수
	
	
		
	public AbstractFactory(int floor, int width, int length, int floorHigh, int mashineNum, int chimneyNum) {
		super(floor, width, length, floorHigh);
		this.mashineNum = mashineNum;
		this.chimneyNum = chimneyNum;
	}



	@Override
	public void madeChimney() {
		// TODO Auto-generated method stub
		
	}
}
