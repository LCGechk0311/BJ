import java.util.Arrays;
import java.util.Scanner;

public class BJ2798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = scanner.nextInt();
        }

        int closestSum = findClosestSum(cards, N, M);

        System.out.println(closestSum);

        scanner.close();
    }

    private static int findClosestSum(int[] cards, int N, int M) {
        int closestSum = 0;

        Arrays.sort(cards);

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    int currentSum = cards[i] + cards[j] + cards[k];

                    if (currentSum <= M && Math.abs(M - currentSum) < Math.abs(M - closestSum)) {
                        closestSum = currentSum;
                    }
                }
            }
        }

        return closestSum;
    }
}
