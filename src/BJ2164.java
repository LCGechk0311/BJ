import java.util.LinkedList;
import java.util.Scanner;

public class BJ2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int lastRemainingCard = findLastRemainingCard(N);

        System.out.println(lastRemainingCard);

        scanner.close();
    }

    private static int findLastRemainingCard(int N) {
        LinkedList<Integer> cards = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            cards.add(i);
        }

        while (cards.size() > 1) {
            cards.removeFirst();

            if (cards.size() > 1) {
                int topCard = cards.removeFirst();
                cards.addLast(topCard);
            }
        }

        return cards.getFirst();
    }
}
