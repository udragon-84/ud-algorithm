package algorithm.lv2;

import java.util.*;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class 기능개발 {
    /*
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> progressList = Arrays.stream(progresses).boxed().collect(Collectors.toList());
        List<Integer> speedList = Arrays.stream(speeds).boxed().collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();

        while (progressList.size() > 0) {
            for (int i = 0; i < progressList.size(); i++) {
                int sum = progressList.get(i) + speedList.get(i);
                progressList.set(i, sum);
            }

            int removeCnt = 0;
            for (int i = 0; i < progressList.size(); i++) {
                if (progressList.get(i) >= 100) {
                    removeCnt++;
                } else {
                    break;
                }
            }

            if (removeCnt > 0) {
                resultList.add(removeCnt);
                for (int i = 0; i < removeCnt; i++) {
                    progressList.remove(0);
                    speedList.remove(0);
                }
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
  */

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        int n = progresses.length;

        int[] daysLeft = new int[n];
        for (int i = 0; i < n; i++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }


        int count = 0;
        int maxDay = daysLeft[0];
        for (int i = 0; i < n; i++) {
            if (daysLeft[i] <= maxDay) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        기능개발 main = new 기능개발();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = main.solution(progresses, speeds);

        System.out.println(Arrays.toString(result));
    }
}
