import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Map<Integer, Integer> cardCounts = new HashMap<>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            int cardNumber = Integer.parseInt(tokenizer.nextToken());
            cardCounts.put(cardNumber, cardCounts.getOrDefault(cardNumber, 0) + 1);
        }

        int M = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int queryNumber = Integer.parseInt(tokenizer.nextToken());
            int count = cardCounts.getOrDefault(queryNumber, 0);
            result.append(count).append(" ");
        }

        System.out.println(result.toString().trim());

        reader.close();
    }
}
