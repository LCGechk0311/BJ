import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int days = calculateDays(A, B, V);

        System.out.println(days);

        br.close();
    }

    private static int calculateDays(int A, int B, int V) {
        int numerator = V - A;
        int denominator = A - B;

        return (numerator + denominator - 1) / denominator + 1;
    }
}
