package javabasic.excollection;

public class Card {// 번호와 무늬 보유

	private String shape; // 무늬 (스페이드, 하트, 다이아몬드, 클로버)
	private Integer num; // 숫자 (A~10,J,Q,K)
	
	Card (String shape, Integer num) {
		this.shape = shape;
		this.num = num;
	}
	
	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Override
		public String toString() {
			return shape+num;
		}
}
