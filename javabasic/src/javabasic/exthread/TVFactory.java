package javabasic.exthread;

public class TVFactory {

	private int TVNum;
	
	public TVFactory() {
		
	}
	
	public TVFactory(int TVNum) {
		this.TVNum = TVNum;
	}

	public int getTVNum() {
		return TVNum;
	}

	public void setTVNum(int tVNum) {
		TVNum = tVNum;
	}

	@Override
	public String toString() {
		return "TVFactory [재고 수량=" + TVNum + "]";
	}
	
}
