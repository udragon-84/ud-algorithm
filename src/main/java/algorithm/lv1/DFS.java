package algorithm.lv1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 깊이 우선 탐색 순회
 * DFS: Depth-First Search
 */
public class DFS {

    // 인접 리스트를 저장할 ArrayList 배열
    private ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private boolean[] visited;
    private ArrayList<Integer> answer;

    public int[] solution(int[][] graph, int start, int n) {
        // 인접리스트를 저장할 List 초기화
        this.adjList = new ArrayList[n + 1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        // 인접리스트를 저장
        Arrays.stream(graph).forEach(edge -> adjList[edge[0]].add(edge[1]));
        // 방문처리 초기화
        this.visited = new boolean[n + 1]; // 기본 false 초기화
        // 방문노드를 저장할 객체
        this.answer = new ArrayList<>();
        // 깊이 우선 탐색 처리
        this.dfs(start);
        return this.answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int now) {
        this.visited[now] = true; // 방문 처리 시도
        this.answer.add(now); // 방문 노드를 담는다.
        for (int next : this.adjList[now]) {
            if (!this.visited[next]) {
                this.dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        int[][] graph = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[] result = dfs.solution(graph, 1, 5);

        // 정답 1, 2, 3, 4, 5
        System.out.println(Arrays.toString(result));

        graph = new int[][]{{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}};
        result = dfs.solution(graph,1, 6);

        // 정답 1, 2, 4, 5, 6, 3
        System.out.println(Arrays.toString(result));
    }

}
