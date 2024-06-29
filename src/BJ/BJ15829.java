import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ15829 {
    private static long calculateHashValue(String s, int r, long M) {
        long hashValue = 0;
        for (int i = 0; i < s.length(); i++) {
            hashValue = (hashValue * r + s.charAt(i) - 'a' + 1) % M;
        }
        return hashValue;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String stringInput = br.readLine().trim();

        int r = 0;
        long M = 1;

        for(int i = 0; i < length; i++) {
            r += ((stringInput.charAt(i) - 96) * M);
            M = (M * 31) % 1234567891;
        }
        System.out.println(r % 1234567891);

        br.close();
    }
}
