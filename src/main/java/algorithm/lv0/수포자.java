package algorithm.lv0;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class 수포자 {

    public int[] solution(int[] answers) {
        int[][] pattern = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for(int j = 0; j < pattern.length; j++) {
                if (answers[i] == pattern[j][i % pattern[j].length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt();
        return IntStream.range(0, scores.length)
                .boxed()
                .filter(i -> scores[i] == maxScore)
                .mapToInt(i -> (i + 1))
                .toArray();
    }

    public static void main(String[] args) {
        수포자 mathGiveUp = new 수포자();
        int[] answers = {1, 2, 3, 4, 5};
        int[] result = mathGiveUp.solution(answers);

        System.out.println(Arrays.toString(result));
    }
}
