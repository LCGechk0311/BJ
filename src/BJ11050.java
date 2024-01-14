import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        long result = calculateBinomialCoefficient(N, K);
        System.out.println(result);

        br.close();
    }

    private static long calculateBinomialCoefficient(int N, int K) {
        if (K == 0 || K == N) {
            return 1;
        }

        long[][] dp = new long[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= Math.min(i, K); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[N][K];
    }
}
