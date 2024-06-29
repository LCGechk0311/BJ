import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int residents = calculateResidents(k, n);

            System.out.println(residents);
        }
    }

    private static int calculateResidents(int floor, int unit) {
        if (floor == 0) {
            return unit;
        }

        int sum = 0;
        for (int i = 1; i <= unit; i++) {
            sum += calculateResidents(floor - 1, i);
        }

        return sum;
    }
}
