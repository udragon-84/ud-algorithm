package algorithm.lv3;

/*
 * 연속 부분 배열의 최대 합 (Maximum Subarray Sum)
 * 문제 설명:
 * 주어진 정수 배열에서 연속된 부분 배열의 합 중에서 가장 큰 값을 찾는 문제입니다.
 * input -2 1 -3 4 -1 2 1 -5 4 -> (4, -1, 2, 1)
 * output: 6
 */
public class MaximumSubarraySum {
    public int solution(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }

    public static void main(String[] args) {
        MaximumSubarraySum main = new MaximumSubarraySum();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int reuslt = main.solution(nums);
        System.out.println("result=" + reuslt);
    }
}
