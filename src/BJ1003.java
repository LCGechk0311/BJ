import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1003 {
    static int[] fibCount0;
    static int[] fibCount1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        computeFibCounts();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            System.out.println(fibCount0[N] + " " + fibCount1[N]);
        }

        br.close();
    }

    static void computeFibCounts() {
        fibCount0 = new int[41];
        fibCount1 = new int[41];

        fibCount0[0] = 1;
        fibCount1[0] = 0;
        fibCount0[1] = 0;
        fibCount1[1] = 1;

        for (int i = 2; i <= 40; i++) {
            fibCount0[i] = fibCount0[i - 1] + fibCount0[i - 2];
            fibCount1[i] = fibCount1[i - 1] + fibCount1[i - 2];
        }
    }
}
