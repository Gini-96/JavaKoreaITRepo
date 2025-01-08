package javabasic.teamproject;

import java.util.Comparator;

public class GameRule implements Comparator<User> {
    @Override
    public int compare(User u1, User u2) {
        return Integer.compare(u2.getScoreAsInt(), u1.getScoreAsInt()); // 높은 점수 순으로 정렬
    }
}
