package javabasic.thread;

// 계좌 클래스
public class Account2 {

	private String name;
	private int money;
	
	public Account2() {
	}

	public Account2(String name, int money) {
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account2 [name=" + name + ", money=" + money + "]";
	}
	
	public synchronized void deposit() {
		this.setMoney(this.getMoney()+500);
	}
	
	public synchronized void withdraw() {
		this.setMoney(this.getMoney()-500);
	}
}
