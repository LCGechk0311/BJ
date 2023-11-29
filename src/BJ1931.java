import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            meetings[i][0] = Integer.parseInt(input[0]);
            meetings[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));

        int maxMeetings = findMaxMeetings(meetings);

        System.out.println(maxMeetings);
    }

    private static int findMaxMeetings(int[][] meetings) {
        int maxMeetings = 1;
        int endTime = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= endTime) {
                maxMeetings++;
                endTime = meetings[i][1];
            }
        }

        return maxMeetings;
    }
}
