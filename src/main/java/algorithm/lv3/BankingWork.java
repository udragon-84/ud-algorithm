package algorithm.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 입, 출금 처리
 * 문제 설명
 * 500원, 1000원, 2000원을 순서대로 입금하면 통장 내역은 다음과 같습니다.
 * [500, 1000, 2000]
 * 1000원을 출금하면 통장 내역은 다음과 같습니다.
 * [500, 1000, 1000]
 * 1500원을 출금하면 통장 내역은 다음과 같습니다.
 * [500, 500]
 * 마지막으로 500원을 입금하면 통장 내역은 다음과 같습니다.
 * [500, 500, 500]
 */
public class BankingWork {

    public int[] solution(int[] depositArray) {
        List<Integer> accountList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int deposit : depositArray) {
            if (deposit > 0) { // 0보다 큰 경우는 입금 처리
                stack.push(deposit);
            } else { // 0보다 작은 경우는 출금 처리
                int withdrawMoney = -deposit;
                while(withdrawMoney > 0 && !stack.isEmpty()) {
                    int amountMoney = stack.pop();
                    withdrawMoney = amountMoney - withdrawMoney;
                    if (withdrawMoney > 0) {
                        stack.push(withdrawMoney);
                        break;
                    }
                    withdrawMoney = -withdrawMoney; // 남은 금액 갱신
                }
            }
        }

        while (!stack.isEmpty()) {
            accountList.add(stack.pop());
        }
        return accountList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        BankingWork bankingWork = new BankingWork();
        // int[] depositArray = {500, 1000, -300, 200, -400, 100, -100};
        int[] depositArray = {500, 1000, 2000, -1000, -1500, 500};
        int[] result = bankingWork.solution(depositArray);
        System.out.println(Arrays.toString(result));
    }

}
