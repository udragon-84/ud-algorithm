package algorithm.lv0;

import java.util.Scanner;

/**
 * 대소문자 바꿔서 출력하기
 * <a href='https://school.programmers.co.kr/learn/courses/30/lessons/181949'>대소문자 바꿔서 출력하기</a>
 */
public class ChangeUpperLowerString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length(); i++) {
            char diffChar = a.charAt(i);
            if (Character.isUpperCase(diffChar)) {
               sb.append(String.valueOf(diffChar).toLowerCase());
            } else {
               sb.append(String.valueOf(diffChar).toUpperCase());
            }
        }
        System.out.println(sb);
    }
}
