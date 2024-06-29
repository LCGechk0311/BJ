import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ9375 {
    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        int[] results = new int[T];

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(reader.readLine());

            Map<String, Integer> outfitCount = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] outfitInfo = reader.readLine().split(" ");
                String outfitType = outfitInfo[1];

                outfitCount.put(outfitType, outfitCount.getOrDefault(outfitType, 0) + 1);
            }

            results[t] = calculateWays(outfitCount);

        }
        for (int result : results) {
            System.out.println(result);
        }

        reader.close();
    }

    private static int calculateWays(Map<String, Integer> outfitCount) {
        int ways = 1;

        for (int count : outfitCount.values()) {
            ways *= (count + 1);
        }

        return ways - 1;
    }
}
