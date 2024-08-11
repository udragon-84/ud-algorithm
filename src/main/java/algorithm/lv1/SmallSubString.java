package algorithm.lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * 크기가 작은 문자열 알고리즘
 * <a href='https://school.programmers.co.kr/learn/courses/30/lessons/147355'>크기가 작은 문자열</a>
 */
public class SmallSubString {

    public int solution(String t, String p) {
        List<Long> subLongList = new ArrayList<>();
        for (int i = 0; i < t.length(); i++) {
            if ((t.length() - i) >= p.length()) {
                String subString = t.substring(i, (p.length() + i));
                subLongList.add(Long.parseLong(subString));
            }
        }
        return (int) subLongList.stream()
                .filter(subLong -> subLong <= Long.parseLong(p)).count();
    }

    public static void main(String[] args) {
        System.out.println("크기가 작은 문자열");
        String t = "3141592";
        String p = "271";

        SmallSubString smallSubString = new SmallSubString();

        int result = smallSubString.solution(t, p);
        System.out.println(result);
    }
}
