package algorithm.lv2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * 영어끝말잇기
 * 프로그래머스: https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> wordList = new ArrayList<>();

        Map<Integer, Integer> personWordCountMap = IntStream.range(0, n)
                .boxed()
                .collect(Collectors.toMap(i -> (i + 1), i -> 0));

        wordList.add(words[0]);
        personWordCountMap.put(1, 1);

        for (int i = 1; i < words.length; i++) {
            int key = (i % n) + 1;
            personWordCountMap.put(key, personWordCountMap.getOrDefault(key, 0) + 1);

            if (wordList.contains(words[i])) {
                answer[0] = key;
                answer[1] = personWordCountMap.get(key);
                return answer;
            }

            if (!words[i].startsWith(words[i-1].substring(words[i-1].length() - 1))) {
                answer[0] = key;
                answer[1] = personWordCountMap.get(key);
                return answer;
            }

            wordList.add(words[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        영어끝말잇기 main = new 영어끝말잇기();
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] result = main.solution(n, words);
        System.out.println(Arrays.toString(result));
    }
}
