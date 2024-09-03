package algorithm.hacker.rank;

/**
 * 해커랭크: https://www.hackerrank.com/challenges/java-string-reverse/problem?isFullScreen=true
 * 코드설명: 앞뒤가 같은 문자열을 Palindrome 라고 한다 같을 경우 YES 아닐 경우 NO 출력
 */
public class Palindrome {



    public static void main(String[] args) {
        String palindrome = "cac";
        StringBuilder sb = new StringBuilder(palindrome);

        System.out.println(sb.reverse().toString().equalsIgnoreCase(palindrome) ? "Yes" : "No");
    }

}
