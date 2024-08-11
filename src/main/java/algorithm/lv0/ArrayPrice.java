package algorithm.lv0;

import java.util.Arrays;

public class ArrayPrice {

//    public int[] solution(int[] arr, int[] query) {
//        int arrayEnd = arr.length;
//        int arrayStart = 0;
//
//        for (int i = 0; i < query.length; i++) {
//            if (i % 2 == 0) { // 짝수
//                arrayEnd--;
//            } else { // 홀수
//                arrayStart++;
//            }
//        }
//
//        return IntStream.range(arrayStart, arrayEnd)
//                .boxed()
//                .mapToInt(i -> arr[i])
//                .toArray();
//    }

    public int[] solution(int[] arr, int[] query) {
        for(int i = 0; i < query.length; i++) {
            if(i % 2 == 0) {
                arr = Arrays.copyOfRange(arr, 0, query[i]+1);
            }else {
                arr = Arrays.copyOfRange(arr, query[i], arr.length);
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        ArrayPrice arrayPrice = new ArrayPrice();
        int[] arr = {3, 4, 5, 6 ,7, 8, 9, 10};
        int[] query = {5};
        int[] result = arrayPrice.solution(arr, query);
        Arrays.stream(result).boxed().forEach(System.out::println);
    }
}
