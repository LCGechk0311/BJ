import java.util.Scanner;

public class BJ11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();

        String numbersString = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int digit = Character.getNumericValue(numbersString.charAt(i));
            sum += digit;
        }

        System.out.println(sum);

        scanner.close();
    }
}
