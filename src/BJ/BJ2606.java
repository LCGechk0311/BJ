import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numComputers = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= numComputers; i++) {
            graph.add(new ArrayList<>());
        }

        int numConnections = Integer.parseInt(br.readLine());

        for (int i = 0; i < numConnections; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int computer1 = Integer.parseInt(st.nextToken());
            int computer2 = Integer.parseInt(st.nextToken());

            graph.get(computer1).add(computer2);
            graph.get(computer2).add(computer1);
        }

        boolean[] infected = new boolean[numComputers + 1];

        dfs(graph, 1, infected);

        int count = 0;
        for (boolean isInfected : infected) {
            if (isInfected) {
                count++;
            }
        }

        System.out.println(count - 1);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int current, boolean[] infected) {
        infected[current] = true;
        for (int neighbor : graph.get(current)) {
            if (!infected[neighbor]) {
                dfs(graph, neighbor, infected);
            }
        }
    }
}
