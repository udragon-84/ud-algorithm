package algorithm.lv1;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
* 완주하지 못한 선수
* https://school.programmers.co.kr/learn/courses/30/lessons/42576
*/
public class 완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> participantMap = this.createParticpantMap(participant);
        for (String runCompletionUser: completion) {
            participantMap.computeIfPresent(runCompletionUser, (key, value) -> value - 1);
        }
        return participantMap
                .entrySet()
                .stream()
                .filter(entryMap -> entryMap.getValue() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining());
    }

    private Map<String, Integer> createParticpantMap(String[] participant) {
        return Arrays.stream(participant)
                .collect(Collectors.toMap(
                        Function.identity(),
                        value -> 1,
                        Integer::sum
                ));
    }

    public static void main(String[] args) {
        완주하지못한선수 main = new 완주하지못한선수();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        String result = main.solution(participant, completion);
        System.out.println(result);
    }
}
