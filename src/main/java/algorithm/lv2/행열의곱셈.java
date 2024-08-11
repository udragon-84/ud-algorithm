package algorithm.lv2;

import java.util.Arrays;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */
public class 행열의곱셈 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("@@@@@@");
        행열의곱셈 multiply = new 행열의곱셈();

        int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
        int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] result = multiply.solution(arr1, arr2);
        Arrays.stream(result).forEach(array -> {
            System.out.println(Arrays.toString(array));
        });
    }
}
