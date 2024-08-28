package algorithm.test.yanolja;

import java.util.Arrays;

public class Solution2 {

    public int[] solution(int[][] v) {
        int[] answer = new int[2];
        for (int i = 0; i < answer.length; i++) {
            if (v[0][i] == v[1][i]) {
                answer[i] = v[2][i];
            } else if (v[0][i] == v[2][i]) {
                answer[i] = v[1][i];
            } else {
                answer[i] = v[0][i];
            }
        }
        Integer.parseInt("0");

        return answer;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[][] arrays = {{1, 4}, {3, 4}, {3, 10}};
        int[] result = solution2.solution(arrays);
        System.out.println(Arrays.toString(result));
    }
}
