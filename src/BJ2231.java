import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int constructor = findSmallestConstructor(N);

        System.out.println(constructor);

        br.close();
    }

    private static int findSmallestConstructor(int N) {
        for (int candidate = 1; candidate <= N; candidate++) {
            int decomposedSum = calculateDecomposedSum(candidate);
            if (decomposedSum == N) {
                return candidate;
            }
        }
        return 0;
    }

    private static int calculateDecomposedSum(int number) {
        int sum = number;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
