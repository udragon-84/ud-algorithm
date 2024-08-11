package algorithm.lv1;

import java.util.Stack;

public class 십진수이진수변환 {

    public String solution (int decimal) {
        Stack<Integer> stack = new Stack<>();

        while(decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        십진수이진수변환 main = new 십진수이진수변환();
        int decimal = 27;
        String result = main.solution(decimal);
        System.out.println(result);
    }
}
