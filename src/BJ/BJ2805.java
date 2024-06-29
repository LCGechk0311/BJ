import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int result = findMaxHeight(heights, M);

        System.out.println(result);
    }

    private static int findMaxHeight(int[] heights, int target) {
        int left = 0;
        int right = getMaxHeight(heights);

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canTakeHome(heights, mid, target)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean canTakeHome(int[] heights, int height, int target) {
        long totalWood = 0;
        for (int h : heights) {
            totalWood += Math.max(0, h - height);
        }
        return totalWood >= target;
    }

    private static int getMaxHeight(int[] heights) {
        int max = 0;
        for (int h : heights) {
            max = Math.max(max, h);
        }
        return max;
    }
}
