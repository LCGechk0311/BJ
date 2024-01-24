import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        Stack<Integer> ledger = new Stack<>();

        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (!ledger.isEmpty()) {
                    ledger.pop();
                }
            } else {
                ledger.push(num);
            }
        }

        long sum = 0;
        while (!ledger.isEmpty()) {
            sum += ledger.pop();
        }

        System.out.println(sum);

        br.close();
    }
}
