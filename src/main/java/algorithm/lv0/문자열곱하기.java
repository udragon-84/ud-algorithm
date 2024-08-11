package algorithm.lv0;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * 문자열 곱하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181940
 */
public class 문자열곱하기 {

    public String solution(String my_string, int k) {
        return IntStream.range(0, k)
                .mapToObj(i -> my_string)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        문자열곱하기 main = new 문자열곱하기();
        String my_string = "love";
        String result = main.solution(my_string, 3);
        System.out.println(result);
    }
}
