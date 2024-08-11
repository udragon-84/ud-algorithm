package algorithm.lv1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * O(n) 문제이므로 일단 현재 players의 등수를 Map으로 관리하자.
 * RunningRace 달리기 경주
 * */
public class RunningRace {

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerRankMap = this.changePlayRankingForMap(players);
        System.out.println(playerRankMap);

        for (int i = 0; i < callings.length; i++) {
            String callingPlayer = callings[i];
            if (playerRankMap.containsKey(callingPlayer)) {
                int currentPlayerRank = playerRankMap.get(callingPlayer);
                for (int j = currentPlayerRank; j > (currentPlayerRank - 1); j--) {
                    playerRankMap.put(players[j-1], j);
                    playerRankMap.put(players[j], j-1);

                    String previousPlayer = players[j-1];
                    players[j-1] = players[j];
                    players[j] = previousPlayer;
                }
            }
        }
        return players;
    }

    private Map<String, Integer> changePlayRankingForMap(String[] players) {
        return IntStream.range(0, players.length)
                .boxed()
                .collect(Collectors.toMap(i -> players[i], i -> i));
    }

    public static void main(String[] args) {
        System.out.println("======달리기 경주======");
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        RunningRace runningRace = new RunningRace();
        String[] resultArray = runningRace.solution(players, callings);
        Arrays.stream(resultArray).forEach(System.out::println);
    }

}
