package algorithm.lv0;

import java.util.HashSet;

public class PickTwo {

    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println("@@@@@");
        PickTwo pickTwo = new PickTwo();
        int[] numbers = {2,1,3,4,1};
        int result[] = pickTwo.solution(numbers);
    }
}
