package algorithm.lv1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/92334
 */
public class 신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        String[] dupRemoveReport = Arrays.stream(report).distinct().toArray(String[]::new);

        Map<String, List<String>> reportMap = this.createReportMap(dupRemoveReport);
        Map<String, Integer> reportCountMap = this.createReportCountMap(dupRemoveReport);

        for (int i = 0; i < id_list.length; i++) {
            String userId = id_list[i];
            answer[i] = this.getUserReportCount(userId, reportMap, reportCountMap, k);
        }
        return answer;
    }

    private int getUserReportCount(String userId, Map<String, List<String>> reportMap, Map<String, Integer> reportCountMap, int k) {
        if (!reportMap.containsKey(userId) || reportMap.get(userId).isEmpty()) return 0;
        return  (int) reportMap.get(userId).stream().filter(
                userReport -> reportCountMap.containsKey(userReport) && reportCountMap.get(userReport) >= k).count();
    }

    private Map<String, Integer> createReportCountMap(String[] reportArray) {
        return Arrays.stream(reportArray)
                .map(reportSplit -> reportSplit.split(" "))
                .collect(Collectors.toMap(
                        reportSplit -> reportSplit[1],
                        reportSplit -> 1,
                        Integer::sum
                ));
    }

    private Map<String, List<String>> createReportMap(String[] reportArray) {
        return Arrays.stream(reportArray)
                .map(report -> report.split(" "))
                .collect(Collectors.toMap(
                        reportSplit -> reportSplit[0],
                        reportSplit -> new ArrayList<>(Collections.singleton(reportSplit[1])),
                        (existing, replacement) -> {
                            if (!existing.contains(replacement.get(0))) {
                                existing.add(replacement.get(0));
                            }
                            return existing;
                        }
                ));
    }

//    private Map<String, List<String>> createReportMap(String[] reportArray) {
//        Map<String, List<String>> reportMap = new HashMap<>();
//        Arrays.stream(reportArray).forEach(report -> {
//            String[] reportSplit = report.split(" ");
//
//            String user = reportSplit[0];
//            String userReport = reportSplit[1];
//
//            if (!reportMap.containsKey(user)) {
//                reportMap.put(user, new ArrayList<>());
//            }
//
//            if (!reportMap.get(user).contains(userReport)) {
//                reportMap.get(user).add(userReport);
//            }
//        });
//        return reportMap;
//    }

    public static void main(String[] args) {
        신고결과받기 main = new 신고결과받기();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = main.solution(id_list, report, k);
        System.out.println("result = " + Arrays.toString(result));
    }
}
