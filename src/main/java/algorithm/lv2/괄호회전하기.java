package algorithm.lv2;

import java.util.HashMap;
import java.util.Stack;

/**
 * 프로그래머스 괄호회전하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/76502
 */
public class 괄호회전하기 {

    private HashMap<Character, Character> bracketMap = new HashMap<>(){{
        put(')', '(');
        put('}', '{');
        put(']', '[');
    }};

    public int solution(String s) {
        int answer = 0;
        String bracketStr = s;
        for (int i = 0; i < s.length(); i++) {
            bracketStr = this.bracketRotation(bracketStr);
            if (isRightBracket(bracketStr)) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isRightBracket(String bracketStr) {
        Stack<Character> stack = new Stack<>();
        boolean isStackAction = false;
        for (int i = 0; i < bracketStr.length(); i++) {
            char bracket = bracketStr.charAt(i);
            if (!this.bracketMap.containsKey(bracket)) {
                stack.push(bracket);
                isStackAction = true;
            } else {
                if (!stack.isEmpty() && bracketMap.get(bracket) == stack.peek()) {
                    stack.pop();
                    isStackAction = true;
                }
            }
        }
        return isStackAction && stack.isEmpty();
    }

    private String bracketRotation(String s) {
        StringBuilder sb = new StringBuilder();
        char firstBreket = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(firstBreket);
        return sb.toString();
    }


    public static void main(String[] args) {
        괄호회전하기 main = new 괄호회전하기();
        // String bracketResult = "[](){}";
        String bracketResult = "}]()[{";
        // String bracketResult = "}}}";
        int result = main.solution(bracketResult);
        System.out.println(result);
    }
}
