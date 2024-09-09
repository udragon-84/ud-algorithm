package algorithm.lv2;

import java.util.Arrays;
import java.util.Stack;

public class 뒤에있는큰수찾기 {

    // 해당 로직은 테스트 케이스 20 ~ 23번까지 시간 초과 발생
    /*
    public int[] solution(int[] numbers) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            boolean isListAddCheck = false;
            for (int k = (i + 1); k < numbers.length; k++) {
                if (numbers[k] > numbers[i]) {
                    numList.add(numbers[k]);
                    isListAddCheck = true;
                    break;
                }
            }
            if (!isListAddCheck) {
                numList.add(-1);
            }
        }
        return numList.stream().mapToInt(Integer::intValue).toArray();
    }
    */

    // for문이 2개가 아닌 1개로 줄인다.
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }


    public static void main(String[] args) {
        뒤에있는큰수찾기 main = new 뒤에있는큰수찾기();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] resultArray = main.solution(numbers);
        System.out.println(Arrays.toString(resultArray));
    }
}
