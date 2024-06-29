import java.util.Scanner;

public class BJ2475 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number * number;
        }
        int verificationNumber = sum % 10;

        System.out.println(verificationNumber);

        scanner.close();
    }
}
