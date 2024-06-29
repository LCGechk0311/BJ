import java.util.Scanner;

public class BJ1978 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int primeCount = 0;

        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();

            if (isPrime(number)) {
                primeCount++;
            }
        }

        System.out.println(primeCount);

        scanner.close();
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
