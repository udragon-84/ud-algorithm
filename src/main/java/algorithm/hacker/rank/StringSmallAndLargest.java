package algorithm.hacker.rank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 해커랭크: https://www.hackerrank.com/challenges/java-string-compare/problem?isFullScreen=true
 * 코드설명: 문자열을 자른후 사전순으로 정렬 후 출력
 */
public class StringSmallAndLargest {

    public String getSmallestAndLargest(String s, int k) {
        List<String> stringList = new ArrayList<>();

        String[] stringDictionary = s.split("");
        for (int i = 0; i < (stringDictionary.length - k) + 1; i++) {
            StringBuilder metaSb = new StringBuilder(stringDictionary[i]);
            for (int j = (i + 1); j < (i + k); j++) {
                metaSb.append(stringDictionary[j]);
            }
            stringList.add(metaSb.toString());
        }
        stringList = stringList.stream()
                .sorted()
                .collect(Collectors.toList());

        String smallest = stringList.get(0);
        String largest = stringList.get(stringList.size() - 1);

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        StringSmallAndLargest main = new StringSmallAndLargest();
        String s = "welcometojava";
        int k = 3;
        String result = main.getSmallestAndLargest(s, k);
        System.out.println(result);
    }

}
