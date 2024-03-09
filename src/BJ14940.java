import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ14940 {
    static int[][] map;
    static int[][] distance;
    static int targetRow;
    static int targetCol;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    targetRow = i;
                    targetCol = j;
                }
            }
        }

        calculateDistances(n, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }

    static void calculateDistances(int n, int m) {
        Queue<int[]> queue = new ArrayDeque<>();

        // 거리 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    distance[i][j] = -1;
                }
            }
        }

        queue.offer(new int[]{targetRow, targetCol});
        distance[targetRow][targetCol] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int d = 0; d < 4; d++) {
                int newRow = row + dr[d];
                int newCol = col + dc[d];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && distance[newRow][newCol] == -1) {
                    queue.offer(new int[]{newRow, newCol});
                    distance[newRow][newCol] = distance[row][col] + 1;
                }
            }
        }
    }
}
