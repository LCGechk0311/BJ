import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int movieNumber = calculateMovieNumber(N);

        System.out.println(movieNumber);
    }

    private static int calculateMovieNumber(int N) {
        int currentNumber = 666;

        int count = 0;

        while (true) {
            if (containsConsecutive6s(currentNumber)) {
                count++;

                if (count == N) {
                    return currentNumber;
                }
            }

            currentNumber++;
        }
    }

    private static boolean containsConsecutive6s(int number) {
        String numStr = Integer.toString(number);
        return numStr.contains("666");
    }
}
