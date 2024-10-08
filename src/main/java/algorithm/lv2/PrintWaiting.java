package algorithm.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrintWaiting {

    public int[] solution(int[][] data) {
        List<Integer> result = new ArrayList<>();

        // PriorityQueue 문서 페이지가 작은거부터 먼저 다시 정렬
        PriorityQueue<int[]> pQueue = new PriorityQueue<>((a, b) -> {
            if (a[2] == b[2]) { // 문서 페이지 출력수가 같으면 시간으로 먼저 들어온게 처리되어야 한다.
                return a[1] - b[1]; //요청 시각 비교
            }
            return a[2] - b[2];
        });

        int currentTime = 0;
        int idx = 0;
        int n = data.length;

        while(!pQueue.isEmpty() || idx < n) {

            if (pQueue.isEmpty() && data[idx][1] > currentTime) {
                currentTime = data[idx][1];
            }

            while(idx < n && data[idx][1] <= currentTime) {
                pQueue.add(data[idx]);
                idx++;
            }

            if (!pQueue.isEmpty()) {
                int[] doc = pQueue.poll();
                result.add(doc[0]);
                currentTime += doc[2];
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        PrintWaiting main = new PrintWaiting();
        int[][] data1 = {{1, 0, 5}, {2, 2, 2}, {3, 3, 1}, {4, 4, 1}, {5, 10, 2}};
        int[] result1 = main.solution(data1);
        System.out.println(Arrays.toString(result1));
    }
}
