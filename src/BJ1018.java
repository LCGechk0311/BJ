import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int minRecolor = calculateMinRecolor(N, M, board);

        System.out.println(minRecolor);
    }

    private static int calculateMinRecolor(int N, int M, char[][] board) {
        int minRecolor = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count1 = 0;
                int count2 = 0;

                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (board[i + x][j + y] != 'W') {
                                count1++;
                            }
                        } else {
                            if (board[i + x][j + y] != 'B') {
                                count1++;
                            }
                        }

                        if ((x + y) % 2 == 0) {
                            if (board[i + x][j + y] != 'B') {
                                count2++;
                            }
                        } else {
                            if (board[i + x][j + y] != 'W') {
                                count2++;
                            }
                        }
                    }
                }

                minRecolor = Math.min(minRecolor, Math.min(count1, count2));
            }
        }

        return minRecolor;
    }
}
