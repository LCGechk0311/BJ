import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ16496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count = st.countTokens();
        String[] A = new String[count];
        int[] B = new int[count];

        for (int i = 0; i < a; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < B.length; i++) {
            A[i] = Integer.toString(B[i]);
        }

        boolean allZeros = true;
        for (int i = 0; i < a; i++) {
            if (!A[i].equals("0")) {
                allZeros = false;
                break;
            }
        }

        if (allZeros) {
            System.out.println("0");
            return;
        }

        Arrays.sort(A, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        StringBuilder result = new StringBuilder();
        for (String s : A) {
            result.append(s);
        }

        System.out.println(result);
    }
}
