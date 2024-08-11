package algorithm.lv2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 오픈채팅방
 * https://school.programmers.co.kr/learn/courses/30/lessons/42888
 */
public class 오픈채팅방 {

    public String[] solution(String[] record) {
        List<String> commandList = new ArrayList<>();
        // [case1] : record에 담긴 명령어 별 userId, 닉네임을 기준으로 맵을 만든다.
        Map<String, String> recordMap = this.createRecordMapForStream(record);
        // [case2] : 맵에 담긴 userId를 기준으로 record for문 돌면서 result 생성하여 새로운 String 배열에 담는다.
        for (int i = 0; i < record.length; i++) {
            String[] commandArr = record[i].split(" ");
            String action = commandArr[0];
            String userId = commandArr[1];
            if (action.equals("Enter")) {
                commandList.add(recordMap.get(userId) + "님이 들어왔습니다.");
            }
            if (action.equals("Leave")) {
                commandList.add(recordMap.get(userId) + "님이 나갔습니다.");
            }
        }
        return commandList.toArray(new String[0]);
    }


    private Map<String, String> createRecordMap(String[] recordArr) {
        Map<String, String> recordMap = new HashMap<>();
        for (String record : recordArr) {
            String[] commandArr = record.split(" ");
            String action = commandArr[0];
            String userId = commandArr[1];
            if (action.equals("Enter") || action.equals("Change")) {
                String nickName = commandArr[2];
                recordMap.put(userId, nickName);
            }
        }
        return recordMap;
    }

    private Map<String, String> createRecordMapForStream(String[] recordArr) {
        return Arrays.stream(recordArr)
                .map(record -> record.split(" "))
                .filter(commandArr -> commandArr[0].equals("Enter") || commandArr[0].equals("Change"))
                .collect(Collectors.toMap(
                    commandArr -> commandArr[1],
                    commandArr -> commandArr[2],
                    (oldCArr, newCArr) -> newCArr
                ));
    }

    public static void main(String[] args) {
        오픈채팅방 main = new 오픈채팅방();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = main.solution(record);
        System.out.println(Arrays.toString(result));
    }
}
