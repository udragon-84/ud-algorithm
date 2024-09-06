package algorithm.hacker.rank;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringToken {

    public static void main(String[] args) {
        // [^A-Za-z]+ 대소문자가 아닌것을 기준으로 split을 해서 나눈다. ^ 부정을 의미 + 기호는 1회 이상 반복
        String[] strTokenArrays = "He is a very very good boy, isn't he?".split("[^A-Za-z]+");
        strTokenArrays = Arrays.stream(strTokenArrays).filter(token -> !token.isEmpty()).toArray(String[]::new);

        System.out.println(strTokenArrays.length);
        for (String token: strTokenArrays) {
            System.out.println(token);
        }
    }
}
