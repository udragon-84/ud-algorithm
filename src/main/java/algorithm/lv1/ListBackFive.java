package algorithm.lv1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ListBackFive {

    public int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
                .boxed()
                .sorted()
                .collect(Collectors.toList())
                .subList(5, num_list.length)
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void main (String[] args) {
        System.out.println("뒤에서 5등 위로");
        ListBackFive listBackFive = new ListBackFive();
        //int[] randomNumList = {12, 4, 15, 46, 38, 1, 14, 56, 32, 10};
        int[] randomNumList = {2, 9, 100, 55, 46, 83, 11, 1, 4, 5, 7};
        // int[] randomNumList = {14, 56, 32, 10, 11, 1};
        int[] resultArry =  listBackFive.solution(randomNumList);
        System.out.println(resultArry);
    }
}
