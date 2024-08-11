package algorithm.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 유니온파인드 {

    private int[] parent;

    public Boolean[] solution(int k, int[][] operation) {
        parent = new int[k];

        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        List<Boolean> answer = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) {
                union(op[1], op[2]);
            } else {
                answer.add(find(op[1]) == find(op[2]));
            }
        }
        return answer.toArray(new Boolean[0]);
    }

    private int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public static void main(String[] args) {
        유니온파인드 main  = new 유니온파인드();
        int k = 3;
        int[][] operation = {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}};
        Boolean[] isResult = main.solution(k, operation);
        System.out.println(Arrays.toString(isResult));
        // int k =4;
        // int[][] operation = {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0, 2}};
    }
}
