import java.util.Scanner;

public class BJ2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        int gcd = calculateGCD(num1, num2);
        System.out.println(gcd);

        int lcm = calculateLCM(num1, num2, gcd);
        System.out.println(lcm);

        scanner.close();
    }

    private static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}
