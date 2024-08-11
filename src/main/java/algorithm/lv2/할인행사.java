package algorithm.lv2;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/131127
 */
public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = IntStream
                .range(0, want.length)
                .boxed()
                .collect(Collectors.toMap(i -> want[i], i -> number[i]));

        for (int i = 0; i < discount.length - 9; i++) {
            int subLoopMaxCnt = (10 + i);
            Map<String, Integer> discountMap = this.createDisCountMap(discount, i, subLoopMaxCnt);
            if (Objects.equals(wantMap, discountMap)) {
                answer++;
            }
        }
        return answer;
    }

    private Map<String, Integer> createDisCountMap(String[] discount, int startIndex, int endIndex) {
        return Arrays.stream(discount, startIndex, endIndex)
                .collect(Collectors.toMap(
                        discountProduct -> discountProduct,
                        discountProduct -> 1,
                        Integer::sum
                ));
    }

//    private Map<String, Integer> createDisCountMap(String[] discount, int startIndex, int endIndex) {
//        Map<String, Integer> disCountMap = new HashMap<>();
//        for (int i = startIndex; i < endIndex; i++) {
//            String discountProduct = discount[i];
//            if (disCountMap.containsKey(discountProduct)) {
//                disCountMap.put(discountProduct, disCountMap.getOrDefault(discountProduct,0) + 1);
//            } else {
//                disCountMap.put(discountProduct, 1);
//            }
//        }
//        return disCountMap;
//    }

    public static void main(String[] args) {
        할인행사 main = new 할인행사();

        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        int result = main.solution(want, number, discount);
        System.out.println("result=" + result);
    }
}
