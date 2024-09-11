package algorithm.lv3;
import java.util.Arrays;

/**
 * R * C 크기의 흑백 이미지가 있습니다. 1 * 1 크기의 각 칸은 한 개의 픽셀을 나타내며, 검은색 또는 흰색으로 이루어져 있고,
 * 검은색 부분은 0, 흰색 부분은 1로 표기됩니다. 이때, 우리는 흰색으로만 이루어진 영역이 몇 개인지 찾으려고 합니다. 영역이란,
 * 픽셀들이 가로 또는 세로로 서로 연결되어 있을때 1개의 영역이라고 하며, 픽셀의 개수가 그 영역의 넓이가 됩니다. 단, 대각선으로 연결된 것은 같은 영역이 아닙니다.
 *
 * 예를 들면, 6 * 5 크기의 이미지
 *
 * 1, 1, 0, 1, 1
 * 0, 1, 1, 0, 0
 * 0, 0, 0, 0, 0
 * 1, 1, 0, 1, 1
 * 1, 0, 1, 1, 1
 * 1, 0, 1, 1, 1
 *
 * 로 주어질때, 흰색 영역은 4개이며, 가장 큰 넓이는 8이 됩니다.
 * 흑백 이미지가 매개변수 v로 주어질 때, 흰석 영역의 개수와 흰색 영역 중에서 가장 큰 넓이를 return하도록 solution 함수를 완성해 주세요.
 * 단, 영역의 개수와 넓이 순으로 return 해주세요. 위의 예시의 경우, [4, 8]을 return 하면 됩니다.
 *
 * 입출력
 * v: [[1, 1, 0, 1, 1],[0, 1, 1, 0, 0],[0, 0, 0, 0, 0],[1, 1, 0, 1, 1],[1, 0, 1, 1, 1],[1, 0, 1, 1, 1]]
 * answer: [4, 8]
 */
public class 흑백이미지구하기 {
    // 방향 벡터: 상, 하, 좌, 우
    private final int[] directionX = {-1, 1, 0, 0};
    private final int[] directionY = {0, 0, -1, 1};

    // DFS를 사용하여 영역 크기를 계산하는 함수
    private int calculateArea(int[][] grid, boolean[][] visited, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        int areaSize = 1;  // 현재 위치의 영역 크기

        visited[x][y] = true;  // 현재 위치를 방문 처리

        // 상하좌우 네 방향으로 탐색
        for (int i = 0; i < 4; i++) {
            int newX = x + directionX[i];
            int newY = y + directionY[i];

            // 범위를 벗어나지 않고, 흰색(1)이며, 방문하지 않은 경우
            if (newX >= 0 && newY >= 0 && newX < rows && newY < cols && grid[newX][newY] == 1 && !visited[newX][newY]) {
                areaSize += calculateArea(grid, visited, newX, newY);  // 재귀적으로 연결된 영역 크기 누적
            }
        }
        return areaSize;  // 계산된 영역 크기 반환
    }

    // 흰색 영역의 개수와 가장 큰 영역 크기를 계산하는 함수
    public int[] solution(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int totalAreas = 0;  // 전체 흰색 영역의 개수
        int maxAreaSize = 0;  // 가장 큰 흰색 영역의 크기

        // 모든 셀을 순회하면서 흰색 영역 탐색
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    totalAreas++;  // 새로운 흰색 영역 발견 시 개수 증가
                    int areaSize = calculateArea(grid, visited, i, j);  // 해당 영역의 크기 계산
                    maxAreaSize = Math.max(maxAreaSize, areaSize);  // 최대 영역 크기 갱신
                }
            }
        }
        return new int[]{totalAreas, maxAreaSize};  // 영역의 개수와 최대 영역 크기를 반환
    }

    public static void main(String[] args) {
        흑백이미지구하기 main = new 흑백이미지구하기();
        int[][] v = {
                {1, 1, 0, 1, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}
        };
        int[] result = main.solution(v); // [4, 8] 반환 예상
        System.out.println(Arrays.toString(result)); // 결과 출력
    }
}
