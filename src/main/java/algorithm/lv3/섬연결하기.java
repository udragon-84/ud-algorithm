package algorithm.lv3;
import java.util.Arrays;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/42861
 */
public class 섬연결하기 {

    private int[] parent;

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int answer = 0; //최소 신장 트리의 총비용
        int edges = 0; // 연결된 다리의 수

        for (int[] edge : costs) {
            // n - 1 개의 다리가 연결된 경우 모든 섬이 연결됨
            if (edges == n - 1) {
                break;
            }
            // 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 확인
            if (find(edge[0]) != find(edge[1])) {
                // 두 섬을 하나의 집합으로 연결함
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        return answer;
    }

    private int find(int x) {
        // x가 속한 집합의 루트 노드 찾기
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static void main(String[] args) {
        섬연결하기 main = new 섬연결하기();
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int result = main.solution(n, costs);
        System.out.println(result);
    }

}
