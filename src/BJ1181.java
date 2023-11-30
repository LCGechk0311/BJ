import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class BJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Set<String> words = new TreeSet<>((word1, word2) -> {
            int lengthComparison = Integer.compare(word1.length(), word2.length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return word1.compareTo(word2);
        });

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
