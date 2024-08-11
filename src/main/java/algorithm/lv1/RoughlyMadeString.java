package algorithm.lv1;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 대충 만든 자판
 * <a href='https://school.programmers.co.kr/learn/courses/30/lessons/160586'>대충 만든 자판</a>
 * <a href='https://school.programmers.co.kr/questions/45366'>Test 14번부터 실패</a>
 */
public class RoughlyMadeString {

    public int[] solution(String[] keymap, String[] targets) {
        return Arrays.stream(targets)
                .mapToInt(target -> this.findByKeyClickCnt(target, keymap))
                .toArray();
    }

    private int findByKeyClickCnt(String target, String[] keymap) {
        int clickCnt = 0;
        boolean noSearchKeyMap = false;
        for (int i = 0; i < target.length(); i++) {
            char key = target.charAt(i);
            int index = this.findByKeyMapIndex(key, keymap);
            if (index >= 0) {
                for (int j = 0; j < keymap[index].length(); j++) {
                    clickCnt++;
                    if (key == keymap[index].charAt(j)) break;
                }
            } else {
                noSearchKeyMap = true;
                break;
            }
        }
        if (noSearchKeyMap) clickCnt = 0;
        return clickCnt <= 0 ? -1 : clickCnt;
    }

    private int findByKeyMapIndex(char key, String[] keymap) {
        int index = -1;
        int keyIndex = 1_000;
        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                if (key == keymap[i].charAt(j) && keyIndex > j) {
                    index = i;
                    keyIndex = j;
                    break;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        RoughlyMadeString roughlyMadeString = new RoughlyMadeString();
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};

        // String[] keymap = {"AA"};
        // String[] targets = {"B"};

        // String[] keymap = {"AGZ", "BSSS"};
        // String[] targets = {"ASA","BGZ"};

        // String[] keymap = {"ABCDE", "ABBCE"};
        // String[] targets = {"ABBEF"};

        // String[] keymap = {"ABCDE", "ABBCE"};
        // String[] targets = {"ABBEF"};

        int[] results = roughlyMadeString.solution(keymap, targets);

        System.out.println(Arrays.stream(results)
                .boxed()
                .collect(Collectors.toList()));
    }
}
