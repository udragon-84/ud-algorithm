package algorithm.lv0;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceGame3 {

    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> diceMap = this.getDiceMapForStream(a, b, c, d);
        int mapSize = diceMap.size();
        // case key 값이 1개인 경우
        if (mapSize == 1) answer = 1111 * a;
        // case key 값이 2개인 경우
        if (mapSize == 2) {
            // value Count가 3인 케이스가 있는지 없는지 검사
            Integer threeValueKey = this.findValueToKey(diceMap, 3);
            if (diceMap.containsKey(threeValueKey)) {
                Integer oneValueKey = this.findValueToKey(diceMap, 1);
                answer = (10 * threeValueKey + oneValueKey) * (10 * threeValueKey + oneValueKey); // 제곱근으로 리턴
            } else { // value Count가 각 2개씩 있는 케이스
                List<Integer> sortedKeyList = new ArrayList<>(diceMap.keySet());
                sortedKeyList.sort(Collections.reverseOrder());
                answer = (sortedKeyList.get(0) + sortedKeyList.get(1)) * (sortedKeyList.get(0) - sortedKeyList.get(1));
            }
        }
        if (mapSize == 3) {
            List<Integer> keyList = diceMap.entrySet().stream().filter(entry -> !Objects.equals(entry.getValue(), 2))
                    .map(Map.Entry::getKey).collect(Collectors.toList());
            answer = keyList.get(0) * keyList.get(1);
        }
        if (mapSize == 4) {
            List<Integer> sortedKeyList = new ArrayList<>(diceMap.keySet());
            Collections.sort(sortedKeyList);
            answer = sortedKeyList.get(0);
        }
        return answer;
    }

    private Integer findValueToKey(Map<Integer, Integer> diceMap, int diffValue) {
        return diceMap.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(), diffValue))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(null);
    }

    // 스트림 처리
    private Map<Integer, Integer> getDiceMapForStream(int a, int b, int c, int d) {
        int[] diceArray = {a, b, c, d};
        return Arrays.stream(diceArray)
                .boxed()
                .collect(Collectors.toMap(
                        Function.identity(),
                        v -> 1,
                        Integer::sum,
                        HashMap::new
                ));
    }

    // 일반 자바
    private Map<Integer, Integer> getDiceMap(int a, int b, int c, int d) {
        int[] diceArray = {a, b, c, d};
        Map<Integer, Integer> diceMap = new HashMap<>();
        for (int j : diceArray) {
            if (diceMap.containsKey(j)) {
                diceMap.put(j, diceMap.get(j) + 1);
            } else {
                diceMap.put(j, 1);
            }
        }
        return diceMap;
    }

    public static void main(String[] args) {
        DiceGame3 diceGame = new DiceGame3();
        int result = diceGame.solution(6, 3,3,6);
        System.out.println("DiceGame: " + result);
        IntStream.range(0, (11)).forEach(o -> System.out.print("Test"));

    }
}
