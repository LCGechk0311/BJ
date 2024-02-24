import java.util.Scanner;

public class BJ27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.nextLine();

        int i = scanner.nextInt();

        char ithCharacter = S.charAt(i - 1);
        System.out.println(ithCharacter);

        scanner.close();
    }
}
