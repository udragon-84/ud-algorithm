package algorithm.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MemoriesScore {
    // LEVEL1, 추억 점수
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> scoreList = Arrays.stream(photo)
                .map(photoArray -> Arrays.stream(photoArray)
                        .map(photoName -> this.findNameScore(name, yearning, photoName))
                        .mapToInt(Integer::intValue)
                        .sum())
                .collect(Collectors.toList());

        return scoreList.stream().mapToInt(Integer::intValue).toArray();
    }

    private int findNameScore(String[] names, int[] yearning, String searchName) {
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (name.equals(searchName)) return yearning[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        MemoriesScore memoriesScore = new MemoriesScore();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {
                {"may", "kein", "kain", "radi"}, // -> 19점
                {"may", "kein", "brin", "deny"}, // -> 15점
                {"kon", "kain", "may", "coni"}   // -> 6점
        };

        int[] results = memoriesScore.solution(name, yearning, photo);
        //19, 15, 6점 순서대로 출력되어야 한다.
        Arrays.stream(results).forEach(System.out::println);
    }
}
