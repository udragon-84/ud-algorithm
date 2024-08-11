package algorithm.lv1;

import java.util.Arrays;

public class 트리순회 {

    public String[] solution(int[] nodes) {
        String[] result = new String[3];
        result[0] = preorder(nodes, 0).trim();
        result[1] = inorder(nodes, 0).trim();
        result[2] = postorder(nodes, 0).trim();
        return result;
    }

    // 전위 순회
    private String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        // 루트노드 -> 왼쪽 서브 트리 -> 오른쪽 서브 트리 순으로 재귀 호출하여 결과를 이어 붙임
        return nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
    }

    // 중위 순회
    private String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        // 왼쪽 서브 트리 -> 루트노드 -> 오른쪽 서브 트리 순으로 재귀
        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    // 중위 순회
    private String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }
        // 왼쪽 트리 -> 루트노드 -> 오른쪽 서브 트리 순으로 재귀
        return postorder(nodes, 2 * idx + 1) + inorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }
    public static void main(String[] args) {
        트리순회 main = new 트리순회();
        int[] nodes = {1, 2, 3, 4, 5, 6, 7};
        String[] treeResult = main.solution(nodes);
        System.out.println("트리순회=" + Arrays.toString(treeResult));
    }
}
