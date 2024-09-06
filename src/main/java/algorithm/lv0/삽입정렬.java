package algorithm.lv0;

import java.util.Arrays;

public class 삽입정렬 {

    public int[] solution (int[] secArray) {
        int key = 1;
        while (key < secArray.length) {
            for (int i = (key - 1); i >= 0; i--) {
                if (secArray[i] > secArray[i + 1]) {
                    int temp = secArray[i];
                    secArray[i] = secArray[i + 1];
                    secArray[i + 1] = temp;
                }
            }
            key++;
        }
        return secArray;
    }

    public static void main(String[] args) {
        삽입정렬 main = new 삽입정렬();
        int[] secArray = {100, 5, 11, 1, 4, 3, 2, 10};
        int[] result = main.solution(secArray);
        System.out.println(Arrays.toString(result));
    }

}
