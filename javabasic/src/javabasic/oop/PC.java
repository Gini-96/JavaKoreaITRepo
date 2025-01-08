package javabasic.oop;

// PC 객체를 생성하려면 Monitor, Desktop, Keyboard 가 있어야함
// *** has a 관계 (위임 관계, delegation)
// 상속받지 않아도 가지고 있으므로 사용할 수 있는 관계
// PC has a Monitor
// PC has a Desktop
// PC has a Keyboard
public class PC {

	String company; // 제조회사
	int price; // 가격
	
	Monitor monitor;
	Desktop desktop;
	Keyboard keyboard;
	
	public PC() {
		
	}

	public PC(String company, Monitor monitor, Desktop desktop, Keyboard keyboard) {
		this.company = company;
		this.price = price;
		this.monitor = monitor;
		this.desktop = desktop;
		this.keyboard = keyboard;
	}
	
	// 아무 생성자도 없을 경우 자동으로 기본 생성자를 만들어주지만 파라미터가 존재하는 생성자를 만들경우 기본 생성자를 만들어 주지 않기 때문에
	// 두가지 다 필요 한경우 기본 생성자를 따로 만들어 두어야 함
	
	public int getPrice() {
		return this.price;
	}
	
	// PC의 가격은 모니터 가격 + 테스크탑 가격 + 키보드 가격
	public void setPrice() {
		this.price = monitor.price + desktop.price + keyboard.price;
	}
	
	
	
	
}
