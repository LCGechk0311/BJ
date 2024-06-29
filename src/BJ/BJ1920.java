import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numberSet.add(num);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int query = Integer.parseInt(st.nextToken());
            if (numberSet.contains(query)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}
