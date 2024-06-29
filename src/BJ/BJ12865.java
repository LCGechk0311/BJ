import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 물품의 수, K: 배낭의 최대 무게
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 각 물품의 무게와 가치를 저장하는 배열
        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];
        // dp 배열: dp[i][j]는 i번째 물품까지 고려했을 때, 배낭 무게가 j일 때의 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // 각 물품의 무게와 가치 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // 다이나믹 프로그래밍을 통한 최적 가치 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 현재 물품을 배낭에 넣을 수 있는 경우
                if (j - weights[i] >= 0) {
                    // 현재 물품을 넣지 않았을 때의 가치(dp[i-1][j])와
                    // 현재 물품을 넣었을 때의 가치(dp[i-1][j-weights[i]] + values[i]) 중 큰 값을 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                } else {
                    // 현재 물품을 배낭에 넣을 수 없는 경우
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 최종 배낭에 넣을 수 있는 물건들의 최대 가치 출력
        System.out.println(dp[N][K]);
    }
}
