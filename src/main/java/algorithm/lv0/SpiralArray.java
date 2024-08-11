package algorithm.lv0;

import java.util.Arrays;
/**
 * 정수를 나선형으로 배치하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/181832
 */
public class SpiralArray {

    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int rowCnt = 0;
        int colCnt = 0;
        int increaseValue = 1;
        int moving = 0;

        while(increaseValue <= n * n) {
            answer[rowCnt][colCnt] = increaseValue++;

            if (moving == 0) { //오른쪽 가로 이동
                if (colCnt < (n - 1) && answer[rowCnt][colCnt + 1] == 0) {
                   colCnt++;
                } else {
                    moving = 1;
                    rowCnt++;
                }
            } else if (moving == 1) { // 아래 세로로 이동
                if (rowCnt < (n - 1) && answer[rowCnt + 1][colCnt] == 0) {
                    rowCnt++;
                } else {
                    moving = 2;
                    colCnt--;
                }
            } else if (moving == 2) { // 왼쪽 가로로 이동
                if (colCnt > 0 && answer[rowCnt][colCnt - 1] == 0) {
                    colCnt--;
                } else {
                    moving = 3;
                    rowCnt--;
                }
            } else { // 3 위 세로로 이동
                if (rowCnt > 0 && answer[rowCnt - 1][colCnt] == 0) {
                    rowCnt--;
                } else {
                    moving = 0;
                    colCnt++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        SpiralArray spiralArray = new SpiralArray();
        int[][] resultSpiralArray = spiralArray.solution(5);
        for (int[] sArrays:resultSpiralArray) {
            // Arrays.stream(SArrays).boxed().forEach(System.out::print);
            System.out.println(Arrays.toString(sArrays));
            System.out.println();
        }
    }

}
