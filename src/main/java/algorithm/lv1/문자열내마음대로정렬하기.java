package algorithm.lv1;

import java.util.Arrays;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class 문자열내마음대로정렬하기 {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ?
                o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
        return strings;
    }

    public static void main(String[] args) {
        문자열내마음대로정렬하기 main = new 문자열내마음대로정렬하기();
        String[] stringArrays = {"sun", "bed", "car"};

        String[] result = main.solution(stringArrays, 1);
        System.out.println(Arrays.toString(result));
    }
}
