package algorithm.hacker.rank;


import java.util.Arrays;

/**
 * 해커랭크: https://www.hackerrank.com/challenges/java-anagrams/problem?isFullScreen=true
 * 코드설명: 두 개의 문자열 a와 b는 동일한 빈도로 동일한 문자를 모두 포함하는 경우 애너그램이라고 합니다.
 * 이 과제의 경우 테스트는 대소문자를 구분하지 않습니다. 예를 들어, CAT의 애너그램은 CAT, ACT, tac, TCA, aTC, CtA입니다.
 */
public class Anagrams {

    public boolean isAnagram(String a, String b) {
        char[] firstStrArray = a.toLowerCase().toCharArray();
        char[] secondStrArray = b.toLowerCase().toCharArray();

        Arrays.sort(firstStrArray);
        Arrays.sort(secondStrArray);

        String firstStr = String.valueOf(firstStrArray);
        String secondStr = String.valueOf(secondStrArray);
        return firstStr.equalsIgnoreCase(secondStr);
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        String firstString = "Hello";
        String secondString = "hello";
        boolean result = anagrams.isAnagram(firstString, secondString);
        System.out.println("result=" + result);
    }

}
