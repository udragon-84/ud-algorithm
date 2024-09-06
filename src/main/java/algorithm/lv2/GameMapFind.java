package algorithm.lv2;

import java.util.ArrayDeque;

/**
 * 게임 맵 최단거리
 * 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/1844
 */
public class GameMapFind {

    private final int[] ry = {0, 0, 1, -1}; // 세로
    private final int[] rx = {1, -1, 0, 0}; // 가로

    public int solution (int[][] maps) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        int M = maps.length; // 세로 크기
        int N = maps[0].length; // 가로 크기
        int[][] dist = new int[M][N]; // 최단 거리를 저장할 배열

        // 시작 위치 초기화
        queue.addLast(new Node(0, 0));
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            Node now  = queue.pollFirst();
            // 갈수 있는 길을 찾아서 queue에 넣고 dist맵 배열에는 증감크기를 넣는다.
            for (int i = 0; i < ry.length; i++) {
                int row = now.r + ry[i];
                int col = now.c + rx[i];

                // 배열을 벗어나는지 검사
                if (row < 0 || col < 0 || row >= M || col >= N) {
                    continue;
                }

                // 1인 길로만 갈 수 있음
                if (maps[row][col] == 0) {
                    continue;
                }

                // 최초로 진입 하는 지점에 대해서 길찾기 시도
                if (dist[row][col] == 0) {
                    queue.addLast(new Node(row, col));
                    dist[row][col] = dist[now.r][now.c] + 1;
                }
            }
        }
        return dist[M-1][N-1] == 0 ? -1 : dist[M-1][N-1];
    }

    public static void main(String[] args) {
        GameMapFind gameMapFind = new GameMapFind();
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };
        int result = gameMapFind.solution(maps);
        System.out.println(result);
    }

    private static class Node {
        private int r;
        private int c;
        public Node (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
