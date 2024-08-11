package algorithm.lv1;

/**
 * RunningRace 달리기 경주
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 */
public class WalkInThePark {

    public int[] solution(String[] park, String[] routes) {
        // park map을 2차원 배열로 분리
        char[][] parkMap = this.createParkMapArray(park);
        // 처음 시작 지점을 구해온다. 2차원 배열의 시작 좌표 [0]세로, [1]가로
        int[] startCoordinates = this.getStringCoordinates(parkMap);
        // 움직임에 대한 좌표를 구한다.
        return getEndCoordinates(parkMap, startCoordinates, routes);
    }

    private int[] getEndCoordinates(char[][] parkMap, int[] startCoordinates, String[] routes) {
        int[] answers = new int[2];
        int parkHeight = parkMap.length;
        int parkWidth = parkMap[0].length;
        int heightMove = startCoordinates[0];
        int widthMove = startCoordinates[1];
        int tempHeightMove = heightMove;
        int tempWidthMove = widthMove;

        for(String route: routes) {
            String[] opnSplit = route.split(" ");
            String operation = opnSplit[0];
            int moveCnt = Integer.parseInt(opnSplit[1]);
            boolean rollBackFlag = false;

            for (int i = 0; i < moveCnt; i++) {
                if (operation.equalsIgnoreCase("E")) tempWidthMove++;
                if (operation.equalsIgnoreCase("S")) tempHeightMove++;
                if (operation.equalsIgnoreCase("W")) tempWidthMove--;
                if (operation.equalsIgnoreCase("N")) tempHeightMove--;
                if (tempHeightMove < 0 || tempHeightMove >= parkHeight) {
                    rollBackFlag = true;
                    break;
                }
                if (tempWidthMove < 0 || tempWidthMove >= parkWidth) {
                    rollBackFlag = true;
                    break;
                }
                if (parkMap[tempHeightMove][tempWidthMove] == 'X') {
                    rollBackFlag = true;
                    break;
                }
            }

            if (rollBackFlag) {
                tempHeightMove = heightMove;
                tempWidthMove = widthMove;
            } else {
                heightMove = tempHeightMove;
                widthMove = tempWidthMove;
            }
        }
        answers[0] = heightMove;
        answers[1] = widthMove;
        return answers;
    }

    private int[] getStringCoordinates(char[][] parkMap) {
        int[] startCoordinates = new int[2];
        for (int i = 0; i < parkMap.length; i++) {
            for (int j = 0; j < parkMap[i].length; j++) {
                char mapAttr = parkMap[i][j];
                if (mapAttr == 'S') {
                    startCoordinates[0] = i;
                    startCoordinates[1] = j;
                }
            }
        }
        return startCoordinates;
    }

    private char[][] createParkMapArray(String[] park) {
        int parkHeight = park.length;
        int parkWidth = park[0].length();
        char[][] parkMapArray = new char[parkHeight][parkWidth];
        for (int i = 0; i < parkHeight; i++) {
            for(int j = 0; j < parkWidth; j++) {
                parkMapArray[i][j] = park[i].charAt(j);
            }
        }
        return parkMapArray;
    }

    public static void main(String[] args) {
        WalkInThePark walkInThePark = new WalkInThePark();


    }
}
