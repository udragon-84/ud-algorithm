package algorithm.lv0;

import java.util.HashSet;
/**
 * 236 페이지
 */
public class 두개의수로_특정값만들기 {

    public boolean solution(int[] arr, int target) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : arr) {
            if (hashSet.contains(target - i)) {
                return true;
            }
            hashSet.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        두개의수로_특정값만들기 main = new 두개의수로_특정값만들기();
        int[] arr = {1, 2, 3, 4, 8};
        int target = 7;

        boolean result = main.solution(arr, target);
        System.out.println(result);
    }

}
