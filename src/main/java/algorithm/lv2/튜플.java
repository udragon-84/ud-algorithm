package algorithm.lv2;
import java.util.*;

/**
 * 프로그래머스
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class 튜플 {

    public int[] solution(String s) {
        Set<Integer> numSet = new LinkedHashSet<>();
        List<List<Integer>> numList = this.createStringToNumList(s);
        numList.sort(Comparator.comparingInt(List::size));
        for (int i = 0; i < numList.size(); i++) {
            numSet.addAll(numList.get(i));
        }
        return numSet.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<List<Integer>> createStringToNumList(String s) {
        String[] splitNums = s.replaceFirst("[{]", "").split("[{]");
        List<List<Integer>> numList = new ArrayList<>();
        for (String strNum : splitNums) {
            strNum = strNum.replace("}}", "").replace("},", "");
            if (!strNum.isBlank()) {
                List<Integer> subNumList = new ArrayList<>();
                for (String strNumElement : strNum.split(",")) {
                    subNumList.add(Integer.parseInt(strNumElement));
                }
                numList.add(subNumList);
            }
        }
        return numList;
    }

    public static void main(String[] args) {
        튜플 main = new 튜플();
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int[] result = main.solution(s);
        System.out.println(Arrays.toString(result));
    }

}
