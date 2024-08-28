package algorithm.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12933
 */
public class 정수내림차순배치하기 {

    public long solution(long n) {
        String[] numArray = String.valueOf(n).split("");
        Arrays.sort(numArray, Comparator.reverseOrder());

        String result = IntStream.range(0, numArray.length)
                .boxed()
                .map(i -> String.valueOf(numArray[i]))
                .collect(Collectors.joining());

        return Long.parseLong(result);
    }

    public static void main(String[] args) {
        정수내림차순배치하기 main = new 정수내림차순배치하기();
        long n = 118372;
        long result = main.solution(n);

        System.out.println(result);
    }
}
