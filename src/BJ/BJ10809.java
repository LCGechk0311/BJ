import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        int[] positions = new int[26];

        for (int i = 0; i < positions.length; i++) {
            positions[i] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (positions[index] == -1) {
                positions[index] = i;
            }
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(positions[i]);
            if (i < 25) {
                System.out.print(" ");
            }
        }
    }
}
