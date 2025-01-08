package javabasic.excollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PokerRule {// 규칙과 로직 보유

//	1. 로얄스트레이트플러쉬 = 10,J,Q,K,A가 같은 모양
//	2. 스트레이트플러쉬 = 같은 모양의 연속된 숫자
//	3. 포카드 = 같은 숫자 4장
//	4. 풀하우스 = 같은 숫자 3장, 같은 숫자 2장
//	5. 플러쉬 = 같은 모양 5장
//	6. 스트레이트 = 모양과 상관없이 연속된 숫자 5장
//	7. 트리플 = 같은 숫자 3장
//	8. 투 페어 = 동일한 숫자 2장과 다른 동일한 숫자 2장
//	9. 원 페어 = 동일한 숫자 2장
//	10. 하이엔드 = 전부 족보에 해당 안할 경우 보유한 카드중 가장 높은 수

	public final static int CARDLIST_SIZE = 7;
	public final static int NUM_COUNT_MAP_SIZE = 14;
	public final static int SHAPE_COUNT_MAP_SIZE = 4;

	// 로얄스트레이트플러쉬 여부 : 연속된 5개의 숫자(스트레이트),동일한 무늬(플러쉬), 10~14까지의 숫자
	public static boolean isRoyalStraightFlush(Player player) {
		return isTenToFourteen(player) && isStraight(player) && isFlush(player);
	}

	// 스트레이트플러쉬 여부 : 연속된 5개의 숫자이고 5개가 동일한 무늬, 로얄 제외 (10~14까지는 아닌것)
	public static boolean isStraightFlush(Player player) {
		return !isTenToFourteen(player) && isStraight(player) && isFlush(player);
	}

	// 포카드 여부 : 4개가 동일한 숫자
	public static boolean isFourCard(Player player) {
//		for (int j = 2; j < NUM_COUNT_MAP_SIZE + 2; j++)
//			if (player.getNumCountMap().get(j) == 4) {
//				return true;}
		Set<Integer> keySet = player.getNumCountMap().keySet();
		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			if (player.getNumCountMap().get((Integer) it.next()) == 4)
				return true;
		}
		return false;
	}

	// 풀하우스 여부 : 트리플 이면서 트리플이거나 트리플 이면서 투페어or원페어
	public static boolean isFullHouse(Player player) {
		if (numOfTriple(player) == 2 || (numOfTriple(player) == 1 && numOfPair(player) == 1)
				|| (numOfTriple(player) == 1 && numOfPair(player) == 2)) {
			return true;
		}
		return false;
	}

	// 플러쉬 여부 : 동일한 무늬 5개 이상
	public static boolean isFlush(Player player) {
		Set<String> keySet = player.getShapeCountMap().keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			if (player.getShapeCountMap().get(it.next()) >= 5)
				return true;
		}
		return false;
	}

	// 스트레이트 여부 : 연속된 번호가 5개 이상
	public static boolean isStraight(Player player) {
//		Collections.sort(player.getCardList()., null);
		List<Integer> straigtList = new ArrayList<Integer>();
		Set<Integer> keySet = player.getNumCountMap().keySet();
		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			Integer num = (Integer) it.next();
			if (player.getNumCountMap().get(num) >= 1) {
				straigtList.add(num);
			}
		}
		if (straigtList.size() >= 5) {
			if (straigtList.size() == 5 &&
					(straigtList.getFirst() - straigtList.getLast()) == -4) {
				return true;
			} else if (straigtList.size() == 6 &&
					((straigtList.get(straigtList.size() - 1) - straigtList.get(1)) == 4||
					(straigtList.get(straigtList.size() - 2) - straigtList.get(0)) == 4)) {
				return true;
			} else if (straigtList.size() == 7 &&
					((straigtList.get(straigtList.size() - 1) - straigtList.get(2)) == 4||
					(straigtList.get(straigtList.size() - 2) - straigtList.get(1)) == 4||
					(straigtList.get(straigtList.size() - 3) - straigtList.get(0)) == 4)) {
				return true;
			}
		}
		return false;
	}

	// 트리플 여부 : 동일한 숫자가 3개 -> 트리플의 수가 1개
	public static boolean isTriple(Player player) {
		if (numOfTriple(player) == 1 && numOfPair(player) == 0)
			return true;
		return false;
	}

	// 투 페어 여부 : 동일한 숫자 2개가 2쌍이상 -> 페어의 수가 2개 이상
	public static boolean isTwoPair(Player player) {
		if ((numOfPair(player) == 2 || numOfPair(player) == 3) && numOfTriple(player) == 0)
			return true;
		return false;
	}

	// 원 페어 여부 : 동일한 숫자 2개가 한쌍만 -> 페어의 수가 1개
	public static boolean isOnePair(Player player) {
		if (numOfPair(player) == 1 && numOfTriple(player) == 0)
			return true;
		return false;
	}

	// 하이엔드 여부
	public static boolean isHighEnd(Player player) {
		return false;
	}

	// 10~14까지의 숫자 여부
	public static boolean isTenToFourteen(Player player) {
		List<Integer> straigtList = new ArrayList<Integer>();
		Set<Integer> keySet = player.getNumCountMap().keySet();
		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			Integer num = (Integer) it.next();
			if (player.getNumCountMap().get(num) >= 1) {
				straigtList.add(num);
			}
		}
		
		List<Integer> royalList = Arrays.asList(10, 11, 12, 13, 14);
		if (isStraight(player) && straigtList.containsAll(royalList)) {
			return true;
		}

		return false;
	}

	// 페어의 수를 반환
	public static int numOfPair(Player player) {
		int pairNum = 0;
//		for (int j = 2; j < NUM_COUNT_MAP_SIZE + 2; j++)
//			if (player.getNumCountMap().get(j) == 2) {
//				pairNum = pairNum + 1;
//			}
		Set<Integer> keySet = player.getNumCountMap().keySet();
		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			if (player.getNumCountMap().get((Integer) it.next()) == 2) {
				pairNum = pairNum + 1;
			}
		}
		return pairNum;

	}

	// 트리플의 수를 반환
	public static int numOfTriple(Player player) {
		int tripleNum = 0;
//		for (int j = 2; j < NUM_COUNT_MAP_SIZE + 2; j++)
//			if (player.getNumCountMap().get(j) == 3) {
//				tripleNum = tripleNum + 1;
//			}
		Set<Integer> keySet = player.getNumCountMap().keySet();
		Iterator<Integer> it = keySet.iterator();
		while (it.hasNext()) {
			if (player.getNumCountMap().get((Integer) it.next()) == 3) {
				tripleNum = tripleNum + 1;
			}
		}
		return tripleNum;
	}

}// class
