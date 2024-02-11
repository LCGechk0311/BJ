import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ17129 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        HashMap<String, String> passwordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            passwordMap.put(input[0], input[1]);
        }

        for (int i = 0; i < M; i++) {
            String siteAddress = br.readLine();
            System.out.println(passwordMap.get(siteAddress));
        }
    }
}
