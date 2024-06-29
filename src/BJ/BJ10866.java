import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "push_front":
                    int x = Integer.parseInt(tokenizer.nextToken());
                    deque.addFirst(x);
                    break;

                case "push_back":
                    int y = Integer.parseInt(tokenizer.nextToken());
                    deque.addLast(y);
                    break;

                case "pop_front":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollFirst());
                    }
                    break;

                case "pop_back":
                    if (deque.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(deque.pollLast());
                    }
                    break;

                case "size":
                    System.out.println(deque.size());
                    break;

                case "empty":
                    System.out.println(deque.isEmpty() ? "1" : "0");
                    break;

                case "front":
                    System.out.println(deque.isEmpty() ? "-1" : deque.peekFirst());
                    break;

                case "back":
                    System.out.println(deque.isEmpty() ? "-1" : deque.peekLast());
                    break;
            }
        }

        reader.close();
    }
}
