package algorithm.lv2;

import java.util.Stack;

public class 짝지어제거하기 {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char diffChar = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == diffChar) {
                stack.pop();
            } else {
                stack.push(diffChar);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        짝지어제거하기 main = new 짝지어제거하기();
        String s = "baabaac";
        int result = main.solution(s);

        System.out.println(result);
    }
}
