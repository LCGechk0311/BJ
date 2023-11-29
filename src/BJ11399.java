import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] withdrawalTimes = new int[N];
        for (int i = 0; i < N; i++) {
            withdrawalTimes[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(withdrawalTimes);

        int totalTime = 0;
        for (int i = 0; i < N; i++) {
            totalTime += withdrawalTimes[i] * (N - i);
        }

        System.out.println(totalTime);

        reader.close();
    }
}
