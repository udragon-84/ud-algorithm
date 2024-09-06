package algorithm.lv2;

import java.util.Arrays;

/**
 * 연속된 부분 수열의 합
 * 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class 연속된부분수열의합 {

    public int[] solution(int[] sequence, int k) {
        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }

            if(sum == k) {
                int range = R - L - 1;
                if((right - left) > range) {
                    left = L;
                    right = R - 1;
                }
            }

            sum -= sequence[L];
        }

        int[] answer = {left, right};

        return answer;
    }

    public static void main(String[] args) {
        연속된부분수열의합 main = new 연속된부분수열의합();
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        System.out.println(Arrays.toString(main.solution(sequence, k)));
    }
}
