package algorithm.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StrSum {

    public static void main(String []args) {
        System.out.println("문자열 묶기");
        StrSum strSum = new StrSum();
        String[] strArr = {"aa", "b", "cc", "ddd", "ee"};
        int solution = strSum.solution(strArr);
        System.out.println(solution);
    }

    private int solution(String[] strArr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Arrays.stream(strArr).forEach(str -> {
            if (countMap.containsKey(str.length())) {
                int strCount = countMap.get(str.length()) + 1;
                countMap.put(str.length(), strCount);
            } else {
                countMap.put(str.length(), 1);
            }
        });

        return countMap.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .get()
                .getValue();
    }
}
