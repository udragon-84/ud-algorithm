package algorithm.lv2;

import java.util.ArrayDeque;

/**
 * 게임 맵 최단거리
 * 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class 게임맵최단거리 {

    // 이동할 수 있는 방향을 나타내는 배열 rx, ry 선언
    private static final int[] rx = {0, 0, 1, -1};  // 세로
    private static final int[] ry = {1, -1, 0, 0};  // 가로

    public int solution(int[][] maps) {

        int N = maps.length; // 세로
        int M = maps[0].length; // 가로

        // 최단 거리를 저장할 배열 생성
        int[][] dist = new int[N][M];

        // bfs 탐색을 위한 큐 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 시작 정점에 대해서 큐에 추가, 최단 거리 저장
        queue.add(new Node(0, 0));
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();

            for(int i = 0; i < 4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 맵 밖으로 나가는 경우 예외 처리
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                // 벽으로 가는 경우 예외 처리
                if (maps[nr][nc] == 0) {
                    continue;
                }

                // 이동하는 위치가 처음 방문하는 경우, queue에 추가하고 거리 갱신
                if (dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c] + 1;
                }
            }
        }
        // 목적지까지 최단 거리 반환, 목적지에 도달하지 못한 경우에는 -1 반환
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }

    public static void main(String[] args) {
        게임맵최단거리 main = new 게임맵최단거리();
        int[][] map = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int result = main.solution(map);
        System.out.println(result);
    }

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
