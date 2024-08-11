package algorithm.lv1;

public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[10000];
        int target = 3200;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        BinarySearch main = new BinarySearch();
        long startTime = System.nanoTime();
        int result = main.binarySearch(arr, target);
        long binarySearchTime = System.nanoTime() - startTime;
        System.out.println("binarySearchTime=" + binarySearchTime);
    }
}
