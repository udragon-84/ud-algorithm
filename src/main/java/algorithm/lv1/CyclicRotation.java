package algorithm.lv1;

import java.util.Arrays;

public class CyclicRotation {

    /**
     * 주어진 배열 A는 N개의 정수로 구성되어 있습니다.
     * 배열을 회전시키는 것은 각 요소가 오른쪽으로 한 인덱스씩 이동하고, 배열의 마지막 요소는 첫 번째 위치로 이동하는 것을 의미합니다.
     * 예를 들어, 배열 A = [3, 8, 9, 7, 6]을 한 번 회전시키면 [6, 3, 8, 9, 7]이 됩니다 (모든 요소가 오른쪽으로 이동하고 6은 첫 번째 위치로 이동).
     *
     * 목표는 배열 A를 K번 회전시키는 것입니다. 즉, 배열의 각 요소를 오른쪽으로 K번 이동시키는 것입니다.
     * A = [3, 8, 9, 7, 6]
     * K = 3
     * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
     * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
     * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
     */
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        int[] answer = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            answer[(i + K) % A.length] = A[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        CyclicRotation main = new CyclicRotation();
        int[] A = { 3, 8, 9, 7, 6 };
        int K = 3;
        int[] result = main.solution(A, K);
        System.out.println(Arrays.toString(result));
    }
}
