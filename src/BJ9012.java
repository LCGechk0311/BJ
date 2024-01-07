import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BJ9012 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        List<String> results = new ArrayList<>();

        for (int t = 0; t < T; t++) {
            String inputString = scanner.next();

            String result = isValidParenthesisString(inputString);

            results.add(result);
        }

        for (String result : results) {
            System.out.println(result);
        }

        scanner.close();
    }

    private static String isValidParenthesisString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
