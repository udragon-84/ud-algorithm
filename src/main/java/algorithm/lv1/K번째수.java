package algorithm.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * k번째 큰 수
 * 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K번째수 {

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] command = commands[i];
            List<Integer> numList = IntStream.range((command[0] - 1), command[1])
                    .boxed()
                    .map(j -> array[j])
                    .sorted()
                    .collect(Collectors.toList());
            answer[i] = numList.get(command[2] - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        K번째수 main = new K번째수();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] result = main.solution(array, commands);
        System.out.println(Arrays.toString(result));
    }
}
