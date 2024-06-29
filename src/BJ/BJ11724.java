import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        boolean[] visited = new boolean[N + 1];

        int connectedComponents = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(adjList, visited, i);
                connectedComponents++;
            }
        }

        System.out.println(connectedComponents);

        br.close();
    }

    private static void dfs(ArrayList<Integer>[] adjList, boolean[] visited, int vertex) {
        visited[vertex] = true;
        for (int adjacentVertex : adjList[vertex]) {
            if (!visited[adjacentVertex]) {
                dfs(adjList, visited, adjacentVertex);
            }
        }
    }
}
