package algorithm.lv1;

import java.util.ArrayDeque;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 요세푸스 {

    public int solution(int N, int K) {
        ArrayDeque<Integer> deque = IntStream.rangeClosed(1, N)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (deque.size() > 1) {
            for (int i = 0; i < (K-1); i++) {
                deque.addLast(deque.pollFirst());
            }
            return deque.pollFirst();
        }

        return deque.pollFirst();
    }

    public static void main(String[] args) {
        요세푸스 main = new 요세푸스();
        int result = main.solution(8, 2);
        System.out.println("result = " + result);
    }


}
