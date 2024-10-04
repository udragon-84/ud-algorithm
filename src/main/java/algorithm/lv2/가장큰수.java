package algorithm.lv2;

import java.util.ArrayList;
import java.util.List;

/**
 * 가장 큰 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class 가장큰수 {

    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> {
            int a = Integer.parseInt(o1 + o2);
            int b = Integer.parseInt(o2 + o1);
            return Integer.compare(b, a);
        });

        StringBuilder sb = new StringBuilder();
        for(String s: list) {
            sb.append(s);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        가장큰수 main = new 가장큰수();
        int[] numberArray = {6, 10, 2};
        String result = main.solution(numberArray);
        System.out.println(result);
    }
}
