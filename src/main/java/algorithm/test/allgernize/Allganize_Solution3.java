package algorithm.test.allgernize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Diagonal Traverse
 * 주어진 M * N 그리드를 대간선 위 대각선 아래로 반복하면서 탐색하는 순서를 구하는 문제
 * 1, 2, 3, 4 ,5
 * 6, 7, 8 ,9, 10
 * 11, 12, 13, 14, 15
 * outPut: 1, 2, 6, 11, 7, 3, 4, 8, 12, 13, 9, 5, 10, 14, 15
 * 풀이 참고: https://leffept.tistory.com/528?category=911825
 */
public class Allganize_Solution3 {

    public String solution(String[] strMetrix) {
        int[][] matrix = this.parseStrToIntMetrix(strMetrix);
        List<Integer> result = new ArrayList<>();

        int m = matrix.length; // row
        int n = matrix[0].length; //col

        // 대각선 방향으로 탐색
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                // 대각선 위로 탐색
                int row = Math.min(i, m - 1);
                int col = i - row;
                while (row >= 0 && col < n) {
                    result.add(matrix[row][col]);
                    row--;
                    col++;
                }
            } else {
                // 대각선 아래로 탐색
                int col = Math.min(i, n - 1);
                int row = i - col;
                while (col >= 0 && row < m) {
                    result.add(matrix[row][col]);
                    row++;
                    col--;
                }
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }

    private int[][] parseStrToIntMetrix(String[] strMetrix) {
        int[][] intMetrix = new int[strMetrix.length][];
        for (int i = 0; i < strMetrix.length; i++) {
            String[] metrixSplit = strMetrix[i].replaceAll("\\[|\\]", "").split(", ");
            intMetrix[i] = new int[metrixSplit.length];
            for (int j = 0; j < metrixSplit.length; j++) {
                intMetrix[i][j] = Integer.parseInt(metrixSplit[j]);
            }
        }
        for (int[] metrix : intMetrix) {
            System.out.println(Arrays.toString(metrix));
        }
        return intMetrix;
    }

    public static void main(String[] args) {
        Allganize_Solution3 main = new Allganize_Solution3();
        String[] input1 = {"[1, 2, 3, 4, 5]", "[6, 7, 8, 9, 10]", "[11, 12, 13, 14, 15]"};
        String result = main.solution(input1);
        System.out.println("result=" + result);
    }
}
