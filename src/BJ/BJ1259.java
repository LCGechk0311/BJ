import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ1259 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> results = new ArrayList<>();

        while (true) {
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }

            if (isPalindrome(number)) {
                results.add("yes");
            } else {
                results.add("no");
            }
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static boolean isPalindrome(int number) {
        String numStr = String.valueOf(number);
        int left = 0;
        int right = numStr.length() - 1;

        while (left < right) {
            if (numStr.charAt(left) != numStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
