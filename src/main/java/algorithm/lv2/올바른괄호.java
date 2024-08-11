package algorithm.lv2;

import java.util.Stack;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 */
public class 올바른괄호 {

    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(') {
                stack.push(bracket);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        올바른괄호 main = new 올바른괄호();
        String s = "((())";
        boolean isBracket = main.solution(s);
        System.out.println("isResult=" + isBracket);
    }
}
