import java.util.Scanner;

public class BJ4153 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            int[] sides = {a, b, c};
            java.util.Arrays.sort(sides);

            if (isRightTriangle(sides[0], sides[1], sides[2])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

        scanner.close();
    }

    private static boolean isRightTriangle(int a, int b, int c) {
        return a * a + b * b == c * c;
    }
}
