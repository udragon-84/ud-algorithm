package algorithm.lv2;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.IntStream;

/*
 *  크레인 인형뽑기 게임
 *  https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class 크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stacks = this.createBoardStacks(board);
        Stack<Integer> basketStack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;
            if (!stacks[move].isEmpty()) {
                if (basketStack.isEmpty()) {
                    basketStack.push(stacks[move].pop());
                } else {
                    if (Objects.equals(stacks[move].peek(), basketStack.peek())) {
                        stacks[move].pop();
                        basketStack.pop();
                        answer = answer + 2;
                    } else {
                        basketStack.push(stacks[move].pop());
                    }
                }
            }
        }
        return answer;
    }

    private Stack<Integer>[] createBoardStacks(int[][] board) {
        @SuppressWarnings("unchecked")
        Stack<Integer>[] stacks = IntStream.range(0, board.length)
                .mapToObj(i -> new Stack<Integer>())
                .toArray(Stack[]::new);

        for (int i = 0; i < board.length; i++) {
            for (int j = (board.length - 1); j >= 0; j--) {
                int boardNum = board[j][i];
                if (boardNum > 0) stacks[i].push(boardNum);
            }
        }

        return stacks;
    }

    public static void main(String[] args) {
        크레인인형뽑기게임 main = new 크레인인형뽑기게임();
        int[][] board = {
                            {0,0,0,0,0},
                            {0,0,1,0,3},
                            {0,2,5,0,1},
                            {4,2,4,4,2},
                            {3,5,1,3,1}
                        };
        int[] moves = {1,5,3,5,1,2,1,4};

        int result = main.solution(board, moves);
        System.out.println("result = " + result);
    }
}
