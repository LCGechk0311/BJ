import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class IntegerStack {
    private Stack<Integer> stack;

    public IntegerStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.pop();
    }

    public int size() {
        return stack.size();
    }

    public int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }
}


public class BJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        IntegerStack stack = new IntegerStack();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            String command = tokenizer.nextToken();

            switch (command) {
                case "push":
                    int x = Integer.parseInt(tokenizer.nextToken());
                    stack.push(x);
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }

        reader.close();
    }
}
