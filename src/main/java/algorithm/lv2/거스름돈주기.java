package algorithm.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 거스름돈주기 {

    private final int[] currencyArray = {100, 50, 10, 1};

    public int[] changeMoney(int amount) {
        List<Integer> changeList = new ArrayList<>();
        for (int coin : currencyArray) {
            while(amount >= coin) {
                amount -= coin;
                changeList.add(coin);
            }
        }
        return changeList.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        거스름돈주기 main = new 거스름돈주기();
        int[] changeMoney = main.changeMoney(123);
        System.out.println(Arrays.toString(changeMoney));
    }

}
