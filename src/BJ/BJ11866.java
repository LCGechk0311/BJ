import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        StringBuilder result = new StringBuilder("<");
        int index = 0;
        while (!circle.isEmpty()) {
            index = (index + K - 1) % circle.size();
            result.append(circle.remove(index)).append(", ");
        }

        result.setLength(result.length() - 2);
        result.append(">");

        System.out.println(result.toString());

        br.close();
    }
}
