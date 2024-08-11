package algorithm.lv3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * 프로그래머스 다단계 판매
 * https://school.programmers.co.kr/learn/courses/30/lessons/77486
 */
public class MultiLevelSellerV2 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = IntStream.range(0, enroll.length).boxed()
                .collect(Collectors.toMap(i -> enroll[i], i -> referral[i]));
        Map<String, Integer> total = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            String curName = seller[i];
            int money = amount[i] * 100;

            while (money > 0 && !curName.equals("-")) {
                total.put(curName, total.getOrDefault(curName,0) + money - (money / 10));
                curName = parent.get(curName);
                money = money / 10;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = total.getOrDefault(enroll[i],0);
        }
        return answer;
    }

    public static void main(String[] args) {
        MultiLevelSeller multiLevelSeller = new MultiLevelSeller();
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        int[] result = multiLevelSeller.solution(enroll, referral, seller, amount);
        System.out.println(Arrays.toString(result));
    }
}
