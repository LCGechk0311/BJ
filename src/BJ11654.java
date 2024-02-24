import java.util.Scanner;

public class BJ11654 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.nextLine().charAt(0);

        int asciiValue = (int) input;
        System.out.println(asciiValue);

        scanner.close();
    }
}
