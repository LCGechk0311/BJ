import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());

        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] importance = new int[N];
            Deque<Integer> queue = new ArrayDeque<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

            for (int i = 0; i < N; i++) {
                importance[i] = Integer.parseInt(st.nextToken());
                queue.offer(i);
                priorityQueue.offer(importance[i]);
            }

            int printCount = 0;
            while (!queue.isEmpty()) {
                int currentDocument = queue.poll();

                if (priorityQueue.peek() == importance[currentDocument]) {
                    printCount++;

                    if (currentDocument == M) {
                        resultBuilder.append(printCount).append("\n");
                        break;
                    }

                    priorityQueue.poll();
                } else {
                    queue.offer(currentDocument);
                }
            }
        }

        System.out.println(resultBuilder.toString());
    }
}
