import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        int[] results = new int[T];

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(reader.readLine());
            results[t] = countWaysToExpress(n);
        }

        for (int result : results) {
            System.out.println(result);
        }

        reader.close();
    }

    private static int countWaysToExpress(int n) {
        int[] ways = new int[n + 1];

        ways[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i - 1 >= 0) {
                ways[i] += ways[i - 1];
            }
            if (i - 2 >= 0) {
                ways[i] += ways[i - 2];
            }
            if (i - 3 >= 0) {
                ways[i] += ways[i - 3];
            }
        }

        return ways[n];
    }
}
