package algorithm.lv1;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 카드뭉치 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> card1Queue = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> card2Queue = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalQueue.isEmpty()) {
            if (!card1Queue.isEmpty() && card1Queue.peekFirst().equals(goalQueue.peekFirst())) {
                card1Queue.pollFirst();
                goalQueue.pollFirst();
            } else if (!card2Queue.isEmpty() && card2Queue.peekFirst().equals(goalQueue.peekFirst())) {
                card2Queue.pollFirst();
                goalQueue.pollFirst();
            } else {
                break;
            }
        }

        return goalQueue.isEmpty() ? "Yes" : "No";
    }

    public static void main(String[] args) {
        카드뭉치 main = new 카드뭉치();
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = main.solution(cards1, cards2, goal);
        System.out.println(result);
    }

}
