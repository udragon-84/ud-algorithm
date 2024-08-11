package algorithm.lv2;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }

        return answer;
    }


    public static void main(String[] args) {
        주식가격 main = new 주식가격();
        // int[] priceArray = {1, 6, 9, 5, 3, 2, 7};
        int[] priceArray = {1, 6, 9, 5};
        int[] result = main.solution(priceArray);
        System.out.println(Arrays.toString(result));
    }
}
