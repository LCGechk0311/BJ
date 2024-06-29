import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9655 {
    static int N;
    static int[] dp = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i < 1001; i++) {
            if((dp[i-1] & dp[i-3]) == 1) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }

        if (dp[N] == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
