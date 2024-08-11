package algorithm.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OurPassword {

    private Map<Integer, String> PASSWORD_DICTIONARY = new HashMap<>(){{
        put(0, "a"); put(10, "k"); put(20, "u");
        put(1, "b"); put(11, "l"); put(21, "v");
        put(2, "c"); put(12, "m"); put(22, "w");
        put(3, "d"); put(13, "n"); put(23, "x");
        put(4, "e"); put(14, "o"); put(24, "y");
        put(5, "f"); put(15, "p"); put(25, "z");
        put(6, "g"); put(16, "q");
        put(7, "h"); put(17, "r");
        put(8, "i"); put(18, "s");
        put(9, "j"); put(19, "t");
    }};

    public String solution(String s, String skip, int index) {
        return Arrays.stream(s.split(""))
                .map(passWord -> this.getChangePassword(passWord, skip, index))
                .collect(Collectors.joining());
    }

    private String getChangePassword(String passWord, String skip, int index) {
        int pDicMapKep = this.searchChangePassWordKey(passWord);
        int idx = 0;
        while(idx < index) {
            pDicMapKep += 1;
            if (pDicMapKep >= this.PASSWORD_DICTIONARY.size()) {
                pDicMapKep = 0;
            }
            String skipStr = this.PASSWORD_DICTIONARY.get(pDicMapKep);
            if (!skip.contains(skipStr)) {
                idx += 1;
            }
        }
        return this.PASSWORD_DICTIONARY.get(pDicMapKep);
    }

    private int searchChangePassWordKey(String passWord) {
        return PASSWORD_DICTIONARY.entrySet()
                .stream()
                .filter(pDicMap-> pDicMap.getValue().equals(passWord))
                .map(Map.Entry::getKey)
                .findAny()
                .orElse(-1);
    }

    public static void main(String[] args) {
        OurPassword ourPassword = new OurPassword();
        String s = "aukks";
        String skip = "wbqd";
        int index = 10;
        System.out.println("s=" + s + ", skip=" + skip + ", index=" + index);
        String changePassword = ourPassword.solution(s, skip, index);
        System.out.println("changePassword: " + changePassword);
    }

}
