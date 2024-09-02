package algorithm.lv1;

import java.util.*;

/**
 * 너비 우선 탐색 순회
 * BFS: Breadth-First Search
 */
public class BFS {

    private List<Integer>[] adjList; // 인접 리스트를 저장할 List 배열
    private boolean[] visited; // 방문 처리 배열
    private List<Integer> answer;

    public int[] solution(int[][] graph, int start, int n) {


        // 1. 인접리스트 배열 초기화
        this.adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. 인접리스트 배열 저장
        Arrays.stream(graph).forEach(edge -> adjList[edge[0]].add(edge[1]));
        // 3. 방문 처리 초기화
        this.visited = new boolean[n + 1];
        answer = new ArrayList<>();
        // 4. bfs
        this.bfs(start);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            int now = queue.poll();
            visited[now] = true;
            answer.add(now);

            for (int nextNode : adjList[now]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS bfs = new BFS();
        int[][] graphs = {{1,2}, {1,3}, {2,4}, {2,5}, {3,6}, {3,7}, {4,8}, {5,8}, {6,9}, {7,9}};
        int start = 1;
        int n = 9;
        int[] result = bfs.solution(graphs, start, n);
        System.out.println(Arrays.toString(result));

        graphs = new int[][]{{1,3}, {3,4}, {3,5}, {5,2}};
        start = 1;
        n = 5;
        result = bfs.solution(graphs, start, n);
        System.out.println(Arrays.toString(result));
    }
}
