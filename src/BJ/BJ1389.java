import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1389 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] kevinBaconNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[A].add(B);
            graph[B].add(A);
        }

        int resultPerson = findSmallestKevinBaconNumber();
        System.out.println(resultPerson);
    }

    static int findSmallestKevinBaconNumber() {
        int minKevinBacon = Integer.MAX_VALUE;
        int resultPerson = -1;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            kevinBaconNumber = new int[N + 1];
            int kevinBaconSum = bfs(i);

            if (kevinBaconSum < minKevinBacon) {
                minKevinBacon = kevinBaconSum;
                resultPerson = i;
            }
        }

        return resultPerson;
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    kevinBaconNumber[next] = kevinBaconNumber[current] + 1;
                }
            }
        }

        int kevinBaconSum = 0;
        for (int i = 1; i <= N; i++) {
            kevinBaconSum += kevinBaconNumber[i];
        }

        return kevinBaconSum;
    }
}
