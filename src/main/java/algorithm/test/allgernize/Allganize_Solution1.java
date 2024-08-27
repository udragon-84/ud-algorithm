package algorithm.test.allgernize;

import java.util.ArrayList;
import java.util.List;

public class Allganize_Solution1 {

    public int solution(int[] arr) {
        // code goes here

        int rotationStandard = arr[0];
        List<Integer> numList = new ArrayList<>();

        for (int i = rotationStandard; i < arr.length; i++) {
            numList.add(arr[i]);
        }

        for (int i = 0; i < rotationStandard; i++) {
            numList.add(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numList.size(); i++) {
            sb.append(numList.get(i));
        }

        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Allganize_Solution1 solution1 = new Allganize_Solution1();
        int result = solution1.solution(new int[]{2, 3, 4, 1, 6, 10});
        System.out.println(result);
    }
}
