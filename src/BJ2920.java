import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] notes = new int[8];
        for (int i = 0; i < 8; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
        }

        String result = checkOrder(notes);

        System.out.println(result);
    }

    public static String checkOrder(int[] notes) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 7; i++) {
            if (notes[i] < notes[i + 1]) {
                descending = false;
            } else if (notes[i] > notes[i + 1]) {
                ascending = false;
            }
        }

        if (ascending) {
            return "ascending";
        } else if (descending) {
            return "descending";
        } else {
            return "mixed";
        }
    }
}
