package algorithm.lv2;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/12985
 */
public class 예상대진표 {

    /*
    public int solution(int n, int a, int b) {
        int answer = 0;
        // a와 b가 같지 않을 때까지 계속 경기
        while (a != b) {
            // 라운드를 진행할 때마다 경기 수 증가
            answer++;
            // 다음 라운드의 참가자 번호 계산
            // (a + 1) / 2를 하면 a가 속한 다음 라운드 번호가 계산됨
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
    */

    public int solution(int n, int a, int b) {
        int answer = 1; // 처음 default 1경기
        Map<Integer, Double> bracketMap = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toMap(i ->  i + 1, i -> (double)i + 1));

        double aValue;
        double bValue;

        while (n > 1) {
            aValue = bracketMap.get(a);
            bValue = bracketMap.get(b);
            if (this.isOneAndOne(aValue, bValue)) {
                return answer;
            }
            bracketMap.put(a, Math.ceil(aValue / 2));
            bracketMap.put(b, Math.ceil(bValue / 2));
            n = n / 2;
            answer++;
        }
        return answer;
    }

    private boolean isOneAndOne(double aValue, double bValue) {
        return Math.abs(aValue - bValue) == 1 && (Math.min(aValue, bValue) % 2) == 1;
    }

    public static void main(String[] args) {
        예상대진표 main = new 예상대진표();
        int n = 8;
        int a = 4;
        int b = 7;
        int result = main.solution(n, a, b);
        System.out.println("Result=" + result);
    }

}
