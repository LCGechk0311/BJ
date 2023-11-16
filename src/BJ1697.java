import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // Subin의 현재 위치
        int K = Integer.parseInt(input[1]); // 동생의 위치

        // Subin이 동생을 찾는 데 걸리는 최소 시간 계산
        int fastestTime = findFastestTime(N, K);

        // 결과 출력
        System.out.println(fastestTime);
    }

    // Subin이 동생을 찾는 데 걸리는 최소 시간을 계산하는 함수
    private static int findFastestTime(int start, int target) {
        // 시작 위치와 동생의 위치가 같으면 0을 반환
        if (start == target) {
            return 0;
        }

        // BFS를 위한 큐와 방문 여부를 저장하는 배열 초기화
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        // 시작 위치를 큐에 추가하고 방문 표시
        queue.offer(start);
        visited[start] = true;

        // 경과 시간 초기화
        int time = 0;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                // 현재 위치에서 -1 또는 +1로 이동하는 경우
                int[] nextPositions = {current - 1, current + 1};
                for (int next : nextPositions) {
                    // 이동한 위치가 범위 내에 있고 방문하지 않았다면
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        // 동생의 위치에 도달했다면 해당 시간 반환
                        if (next == target) {
                            return time + 1;
                        }
                        // 큐에 추가하고 방문 표시
                        queue.offer(next);
                        visited[next] = true;
                    }
                }

                // 현재 위치에서 *2로 순간이동하는 경우
                int teleport = current * 2;
                // 순간이동한 위치가 범위 내에 있고 방문하지 않았다면
                if (teleport >= 0 && teleport <= 100000 && !visited[teleport]) {
                    // 동생의 위치에 도달했다면 해당 시간 반환
                    if (teleport == target) {
                        return time + 1;
                    }
                    // 큐에 추가하고 방문 표시
                    queue.offer(teleport);
                    visited[teleport] = true;
                }
            }

            // 시간 증가
            time++;
        }

        // 동생을 찾지 못한 경우 -1 반환
        return -1;
    }
}
