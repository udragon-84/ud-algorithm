package algorithm.test.allgernize;

import java.util.HashMap;
import java.util.Map;

public class Allganize_Solution2 {

    public String solution(String str) {
        String[] words = str.split(" ");
        String result = "-1";
        int maxRepeats = 0;

        for (String word : words) {
            int repeats = getWordMaxCount(word);
            if (repeats > maxRepeats) {
                maxRepeats = repeats;
                result = word;
            }
        }
        return maxRepeats > 1 ? result : "-1";
    }

    private int getWordMaxCount(String word) {
        Map<Character, Integer> letterCount = new HashMap<>();
        int maxCount = 0;
        for (char c : word.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
            maxCount = Math.max(maxCount, letterCount.get(c));
        }
        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println("Allganize_Solution2");
        Allganize_Solution2 main = new Allganize_Solution2();
        String result = main.solution("Hello apple pie");
        System.out.println(result);
    }
}
