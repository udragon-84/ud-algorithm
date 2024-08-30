package algorithm.test.yanolja;
import java.util.*;

public class Solution1 {


    public static List<Integer> findSubsequence(List<Integer> arr) {
        int n = arr.size();
        int minLength = Integer.MAX_VALUE;
        List<Integer> result = List.of(-1);

        // 고유한 요소가 이미 충분히 있는지 확인
        Set<Integer> uniqueSet = new HashSet<>(arr);
        if (uniqueSet.size() == n) {
            return List.of(-1); // 이미 고유한 요소로만 구성된 경우
        }

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            int duplicates = 0;

            for (int j = i; j < n; j++) {
                int num = arr.get(j);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);

                if (countMap.get(num) > 1) {
                    duplicates++;
                }

                // 오름차순 부분 시퀀스이고 고유성을 만족하면 결과에 추가
                if (duplicates > 0 && isSorted(arr.subList(i, j + 1))) {
                    List<Integer> remaining = new ArrayList<>(arr);
                    remaining.subList(i, j + 1).clear();

                    if (isUnique(remaining)) {
                        int length = j - i + 1;
                        if (length < minLength) {
                            minLength = length;
                            result = new ArrayList<>(arr.subList(i, j + 1));
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isSorted(List<Integer> subseq) {
        for (int i = 1; i < subseq.size(); i++) {
            if (subseq.get(i) < subseq.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isUnique(List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        return set.size() == arr.size();
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        List<Integer> arr1 = Arrays.asList(5, 100, 2, 7, 2, 100);
        System.out.println(Solution1.findSubsequence(arr1)); // Expected output: [2, 100]

        List<Integer> arr2 = Arrays.asList(12, 3, 3, 8, 7, 3, 7, 8, 8, 9, 1000000, 9, 1000000);
        System.out.println(Solution1.findSubsequence(arr2)); // Expected output: [3, 3, 7, 8, 8, 9, 1000000]




    }
}
