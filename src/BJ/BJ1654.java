import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] cables = new int[K];
        for (int i = 0; i < K; i++) {
            cables[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cables);

        long max = cables[K-1];
        long min = 1;
        long middle = 0;

        while(max >= min){
            middle = (max + min)/2;

            long count = 0;

            for(int j = 0;j < cables.length;j++){
                count += cables[j]/middle;
            }

            if(count >= N){
                min = middle + 1;
            }else if(count < N){
                max = middle - 1;
            }
        }

        System.out.println(max);
    }

}