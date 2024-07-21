package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class BJ10026 {
    static int N;
    static char[][] grid;
    static boolean[][] visitedNormal;
    static boolean[][] visitedColorBlind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visitedNormal = new boolean[N][N];
        visitedColorBlind = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int normalZones = 0; // 정상 시력의 경우 카운트 수
        int colorBlindZones = 0; // 색맹의 경우 카운트 수

        // 정상 시력을 위한 구역 수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedNormal[i][j]) {
                    dfs(i, j, grid[i][j], false);
                    normalZones++;
                }
            }
        }

        // 적록색맹 시력을 위한 구역 수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visitedColorBlind[i][j]) {
                    dfs(i, j, grid[i][j], true);
                    colorBlindZones++;
                }
            }
        }

        System.out.println(normalZones + " " + colorBlindZones);
    }

    static void dfs(int x, int y, char color, boolean isColorBlind) {
        // 경계 확인
        if (x < 0 || y < 0 || x >= N || y >= N)
            return;

        if (isColorBlind) {
            if (visitedColorBlind[x][y] || (color != 'B' && grid[x][y] == 'B') || (color == 'B' && grid[x][y] != 'B'))
                return;
            visitedColorBlind[x][y] = true;
        } else {
            if (visitedNormal[x][y] || grid[x][y] != color)
                return;
            visitedNormal[x][y] = true;
        }

        dfs(x - 1, y, color, isColorBlind);
        dfs(x + 1, y, color, isColorBlind);
        dfs(x, y - 1, color, isColorBlind);
        dfs(x, y + 1, color, isColorBlind);
    }
}