import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int totalMinutes = H * 60 + M;
        int adjustedTime = totalMinutes - 45;

        if (adjustedTime < 0) {
            adjustedTime += 24 * 60;
        }

        int adjustedHours = adjustedTime / 60;
        int adjustedMinutes = adjustedTime % 60;

        System.out.println(adjustedHours + " " + adjustedMinutes);
    }
}
