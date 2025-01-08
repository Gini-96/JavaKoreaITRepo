package javabasic.excollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerMain {// 실행

	public static void main(String[] args) {

		// 플레이어 5명을 만든다
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("홍길동", Collections.EMPTY_LIST));
		playerList.add(new Player("이순신", Collections.EMPTY_LIST));
		playerList.add(new Player("강감찬", Collections.EMPTY_LIST));
		playerList.add(new Player("권율", Collections.EMPTY_LIST));
		playerList.add(new Player("최영", Collections.EMPTY_LIST));

		// 카드를 52장 만든다 (스페이드 13장(S), 다이아몬드 13장(D), 하트 13장(H), 클로버 13장(C)
		List<Card> totalCardList = new ArrayList<Card>();
		List<String> shapeList = new ArrayList<String>();
		shapeList.add("S");
		shapeList.add("D");
		shapeList.add("H");
		shapeList.add("C");
		for (int i = 0; i < shapeList.size(); i++) {
			for (int j = 2; j < 15; j++) {
				totalCardList.add(new Card(shapeList.get(i), j));
			}
		}
		System.out.println(totalCardList);
//		for (int i=2; i<15;i++) { // 내가 작성한것
//			totalCardList.add(new Card("S", i));
//			totalCardList.add(new Card("D", i));
//			totalCardList.add(new Card("H", i));
//			totalCardList.add(new Card("C", i));
//		}

		// 카드를 셔플
		Collections.shuffle(totalCardList);
		System.out.println(totalCardList);

		// 플레이어 들에게 7장씩 나눠준다
		System.out.println(playerList);
//		playerList.set(0, new Player("홍길동", totalCardList.subList(0, 6)));
		for (int i = 0; i < playerList.size(); i++) {
			playerList.get(i).setCardList(totalCardList.subList(i * 7, (i * 7) + 7));
		}

		// 플레이어의 숫자 카운트 맵, 무늬카운트 맵을 초기화하고 값을 설정
		for (int i = 0; i < playerList.size(); i++) {
			// 플레이어의 숫자 카운트맵, 무늬카운트맵을 생성
			Player player = playerList.get(i);
			player.setNumCountMap(new HashMap<Integer, Integer>());
			player.setShapeCountMap(new HashMap<String, Integer>());

			// 플레이어의 숫자 카운트맵, 무늬카운트맵을 초기화
			initMap(player.getNumCountMap(), player.getShapeCountMap());

			// 카드의 숫자, 무늬 카운팅
			for (Card card : player.getCardList()) {
				player.getNumCountMap().put(card.getNum(), player.getNumCountMap().get(card.getNum()) + 1);
				player.getShapeCountMap().put(card.getShape(), player.getShapeCountMap().get(card.getShape()) + 1);
			}

		}

		System.out.println(playerList);

		for (Player player : playerList) {
			System.out.println(player);
			printResult(player);
			scoerResult(player);
			printWinner(player);
		}
		
		List<Integer> scorePlayer = new ArrayList<Integer>();
		for (int i=0;i<playerList.size();i++) {
			Player player = playerList.get(i);
			scorePlayer.add(player.getScore());
		}
		
		System.out.println(scorePlayer);

		System.out.println();
	}// main

	// 플레이어의 숫자 카운트맵, 무늬카운트맵을 초기화
	private static void initMap(Map<Integer, Integer> numCountMap, Map<String, Integer> shapeCountMap) {
		for (int i = 2; i < 15; i++) {
			numCountMap.put(i, 0);
		}
		shapeCountMap.put("S", 0);
		shapeCountMap.put("D", 0);
		shapeCountMap.put("H", 0);
		shapeCountMap.put("C", 0);
	}

	private static void printResult(Player player) {
		String resultStr = "";
		if (PokerRule.isRoyalStraightFlush(player)) {
			resultStr = "[RoyalStraightFlush]";
		} else if (PokerRule.isStraightFlush(player)) {
			resultStr = "StraightFlus";
		} else if (PokerRule.isFourCard(player)) {
			resultStr = "FourCard";
		} else if (PokerRule.isFullHouse(player)) {
			resultStr = "FullHouse";
		} else if (PokerRule.isFlush(player)) {
			resultStr = "Flushs";
		} else if (PokerRule.isStraight(player)) {
			resultStr = "Straight";
		} else if (PokerRule.isTriple(player)) {
			resultStr = "Triple";
		} else if (PokerRule.isTwoPair(player)) {
			resultStr = "TwoPair";
		} else if (PokerRule.isOnePair(player)) {
			resultStr = "OnePair";
		} else {
			resultStr = "HighEnd";
		}
		System.out.println(resultStr);
	}

	private static void scoerResult(Player player) {
			if (PokerRule.isRoyalStraightFlush(player)) {
				player.setScore(10);
			} else if (PokerRule.isStraightFlush(player)) {
				player.setScore(9);
			} else if (PokerRule.isFourCard(player)) {
				player.setScore(8);
			} else if (PokerRule.isFullHouse(player)) {
				player.setScore(7);
			} else if (PokerRule.isFlush(player)) {
				player.setScore(6);
			} else if (PokerRule.isStraight(player)) {
				player.setScore(5);
			} else if (PokerRule.isTriple(player)) {
				player.setScore(4);
			} else if (PokerRule.isTwoPair(player)) {
				player.setScore(3);
			} else if (PokerRule.isOnePair(player)) {
				player.setScore(2);
			} else {
				player.setScore(1);
			}
		}

	private static void printWinner (Player player) {
		String winnerName = "";
		List<Integer> scorePlayer = new ArrayList<Integer>();
		scorePlayer.add(player.getScore());
		for (int i=0;i<scorePlayer.size()-1;i++) {
			if (scorePlayer.get(i)>scorePlayer.get(i+1)) {
				winnerName = player.getName();
			}
		}
		System.out.println(winnerName);
	}

//	// 카드 숫자별 수를 계산
//		public static void putNumMap(List<Card> cardList) {
//			for (int i = 0; i < CARDLIST_SIZE; i++) {
//				for (int j = 0; j < SHAPE_COUNT_MAP_SIZE; j++) {
//					if (numCountMap.get(cardList.get(i).getNum()) == j) {
//						numCountMap.put(cardList.get(i).getNum(), j);
//					}
//				}
//			}
//		}
//		// 카드 무늬별 수를 계산
//		public static void putShapeMap(List<Card> cardList) {
//			for (int i = 0; i < CARDLIST_SIZE; i++) {
//				for (int j = 0; j < SHAPE_COUNT_MAP_SIZE; j++) {
//					if ()
//				}
//			}
//		}

}// class
