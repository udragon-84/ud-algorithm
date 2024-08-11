package algorithm.lv2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 *
 */
public class 메뉴리뉴얼 {

    private static HashMap<Integer, HashMap<String, Integer>> courseMap;

    public String[] solution(String[] orders, int[] course) {
        courseMap = new HashMap<>();
        // 해쉬맵 초기화
        IntStream.of(course).forEach(i -> courseMap.put(i, new HashMap<>()));

        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            combinations(0, orderArray, "");
        }


        return new String[1];
    }

    private void combinations(int idx, char[] order, String result) {
        if (courseMap.containsKey(result.length())) {
            HashMap<String, Integer> map = courseMap.get(result.length());
            map.put(result, map.getOrDefault(result, 0) + 1);
        }
        for (int i = idx; i < order.length; i++) {
            combinations(i + 1, order, result + order[i]);
        }
    }


    public static void main(String[] args) {
        메뉴리뉴얼 main = new 메뉴리뉴얼();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] result = main.solution(orders, course);
        System.out.println(Arrays.toString(result));
    }

}
