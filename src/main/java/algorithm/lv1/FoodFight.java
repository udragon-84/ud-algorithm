package algorithm.lv1;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Food Fight 푸듶파이트 대회
 * <a href='https://school.programmers.co.kr/learn/courses/30/lessons/134240'>푸드 파이트 대회</a>
 */
public class FoodFight {
    public String solution(int[] food) {
        String answer = IntStream.range(1, food.length)
                .mapToObj(i -> this.eatFood(i, food))
                .collect(Collectors.joining());
        return answer + "0" + this.foodReverse(answer);
    }
    private String eatFood(int i, int[] food) {
        return IntStream.range(0, (food[i] / 2))
                .mapToObj(f -> String.valueOf(i))
                .collect(Collectors.joining());
    }

    private String foodReverse(String answer) {
        StringBuilder reverse = new StringBuilder();
        for (int i = (answer.length() - 1); i >= 0; i--) {
            reverse.append(answer.charAt(i));
        }
        return reverse.toString();
    }


    public static void main(String[] args) {
        System.out.println("Food Fight 푸드파이트 대회");
        int[] food = { 1, 3, 4, 6 };

        FoodFight foodFight = new FoodFight();
        String result = foodFight.solution(food);

        System.out.println("result: " + result);
    }
}
