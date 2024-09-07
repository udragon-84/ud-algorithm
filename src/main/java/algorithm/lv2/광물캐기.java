package algorithm.lv2;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 광물캐기
 * https://school.programmers.co.kr/learn/courses/30/lessons/172927
 */
public class 광물캐기 {

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        ArrayDeque<Pickaxes> arrayDeque = this.createPricaxes(picks);
        ArrayDeque<String> arrayMinerals = new ArrayDeque<>(Arrays.asList(minerals));

        while (!arrayDeque.isEmpty() && !arrayMinerals.isEmpty()) {
             Pickaxes pickaxe = arrayDeque.pollFirst();

             while(pickaxe.getDurability() > 0 && !arrayMinerals.isEmpty()) {
                 String mineral = arrayMinerals.pollFirst();
                 answer += this.calcMinerals(pickaxe.pickAxesName, mineral);
                 pickaxe.setDurability(pickaxe.getDurability() - 1);
             }
        }
        return answer;
    }

    private int calcMinerals(String pickAxesName, String mineral) {
        if (pickAxesName.equals("dia")) return 1;
        if (pickAxesName.equals("iron") && mineral.equals("diamond")) return 5;
        if (pickAxesName.equals("iron")) return 1;
        if (pickAxesName.equals("stone") && mineral.equals("diamond")) return 25;
        if (pickAxesName.equals("stone") && mineral.equals("iron")) return 5;
        if (pickAxesName.equals("stone")) return 1;
        return 0;
    }

    private ArrayDeque<Pickaxes> createPricaxes(int[] picks) {
        ArrayDeque<Pickaxes> arrayDeque = new ArrayDeque<>();
        IntStream.range(0, picks[0]).forEach(i -> arrayDeque.addLast(new Pickaxes("dia")));
        IntStream.range(0, picks[1]).forEach(i -> arrayDeque.addLast(new Pickaxes("iron")));
        IntStream.range(0, picks[2]).forEach(i -> arrayDeque.addLast(new Pickaxes("stone")));
        return arrayDeque;
    }

    public static void main(String[] args) {
        광물캐기 main = new 광물캐기();
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        int result = main.solution(picks, minerals);
        System.out.println(result);
    }

    /**
     * 곡갱이 도메인
     */
    private static class Pickaxes {
        private String pickAxesName; // 곡갱이 명
        private int durability = 5; // 내구력 0되면 사용 못함

        public Pickaxes(String pickAxesName) {
            this.pickAxesName = pickAxesName;
        }

        public void setDurability(int durability) {
            this.durability = durability;
        }

        public int getDurability() {
            return this.durability;
        }
    }
}
