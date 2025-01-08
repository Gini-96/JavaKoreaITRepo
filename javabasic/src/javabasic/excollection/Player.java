package javabasic.excollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {// 카드를 보유 (총 52장 중에 한사람당 7장씩)

	private String name;
	private int score;
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private List<Card> cardList;
	private Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
	private Map<String, Integer> shapeCountMap = new HashMap<String, Integer>();
	
	public Map<Integer, Integer> getNumCountMap() {
		return numCountMap;
	}

	public void setNumCountMap(Map<Integer, Integer> numCountMap) {
		this.numCountMap = numCountMap;
	}

	public Map<String, Integer> getShapeCountMap() {
		return shapeCountMap;
	}

	public void setShapeCountMap(Map<String, Integer> shapeCountMap) {
		this.shapeCountMap = shapeCountMap;
	}

	public Player() {
	}

	Player(String name, List<Card> cardList) {
		this.name = name;
		this.cardList = cardList;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	@Override
		public String toString() {
			return name + "이 보유한 카드는" +cardList+"\n"+numCountMap+"\n"+shapeCountMap+"\n";
		}
}
