package algorithm.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 프린트출력 {

    public int[] solution(int[][] data) {
        List<Integer> result = new ArrayList<>();

        // 우선순위 큐: 페이지 수가 적은 문서가 먼저 인쇄되며, 페이지 수가 같으면 먼저 요청된 문서부터 인쇄
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) { //요청 페이지가 같을 경우
                return a[1] - b[1]; //요청 시각 비교
            }
            return a[2] - b[2]; //페이지 수 비교
        });

        int currentTime = 0;
        int idx = 0;
        int n = data.length;

        while (!pq.isEmpty() || idx < n) {
            if (pq.isEmpty() && data[idx][1] > currentTime) {
                currentTime = data[idx][1];
            }

            while(idx < n && data[idx][1] <= currentTime) {
                pq.add(data[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                int[] doc = pq.poll();
                result.add(doc[0]);
                currentTime += doc[2];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        프린트출력 main = new 프린트출력();
        int[][] data1 = {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
        int[] result1 = main.solution(data1);
        System.out.println(Arrays.toString(result1));

//        int[][] data2 = {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};
//        int[] result2 = main.solution(data2);
//        System.out.println(Arrays.toString(result2));
//
//        int[][] data3 = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
//        int[] result3 = main.solution(data3);
//        System.out.println(Arrays.toString(result3));
    }
}
