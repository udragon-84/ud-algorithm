package algorithm.lv2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 프로그래머스 숫자 변환하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/154538
 */
public class 숫자변환하기 {

    public int solution(int x, int y, int n) {
        if (x == y) return 0; // 연산이 같다면 연산 필요 없음

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});

        boolean[] visited = new boolean[y + 1]; // 방문여부 배열
        visited[x] = true; // 시작 숫자는 방문 체크

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int value = current[0];
            int steps = current[1];

            // 가능한 값들을 계산: +n, *2, *3
            int[] nextValues = {value + n, value * 2, value * 3};
            for (int next : nextValues) {
                if (next == y) return steps + 1;

                if (next < y && !visited[next]) {
                    queue.add(new int[]{next, steps + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        숫자변환하기 main = new 숫자변환하기();
        int result = main.solution(x, y, n);
        System.out.println(result);
    }
}
