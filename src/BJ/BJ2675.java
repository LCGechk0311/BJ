import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[0]);
            String S = input[1];

            String result = repeatCharacters(S, R);
            System.out.println(result);
        }
    }

    private static String repeatCharacters(String s, int R) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            for (int i = 0; i < R; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
