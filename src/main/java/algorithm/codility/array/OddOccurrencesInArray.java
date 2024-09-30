package algorithm.codility.array;

import java.util.HashMap;
import java.util.Map;

/**
 * OddOccurrencesInArray
 * 주어진 배열 A는 N개의 정수로 이루어져 있으며, N은 홀수입니다.
 * 이 배열에서 한 요소를 제외한 모든 요소는 짝을 이룹니다.
 * 즉, 배열의 각 요소는 같은 값을 가진 다른 요소와 짝을 이룰 수 있는데, 딱 하나의 요소만 짝을 이루지 않습니다.
 * 예를 들어, 배열 A가 다음과 같다면:
 * A[0] = 9  A[1] = 3  A[2] = 9
 * A[3] = 3  A[4] = 9  A[5] = 7
 * A[6] = 9
 * 인덱스 0과 2에 있는 값 9는 서로 짝이 됩니다.
 * 인덱스 1과 3에 있는 값 3도 서로 짝이 됩니다.
 * 인덱스 4와 6에 있는 값 9도 짝을 이룹니다.
 * 그러나 인덱스 5에 있는 값 7은 짝이 없으므로 이 값이 남은 값입니다.
 */
public class OddOccurrencesInArray {

    public int solution(int[] A) {
        Map<Integer, Integer> map = this.createNumMap(A);
        return map.entrySet()
                .stream()
                .filter(entryMap -> entryMap.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .findAny().orElse(0);
    }

    private Map<Integer, Integer> createNumMap(int[] A) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            numMap.put(A[i], numMap.getOrDefault(A[i], 0) + 1);
        }
        return numMap;
    }

    public static void main(String[] args) {
        OddOccurrencesInArray main = new OddOccurrencesInArray();
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        int result = main.solution(A);
        System.out.println(result);
    }
}
