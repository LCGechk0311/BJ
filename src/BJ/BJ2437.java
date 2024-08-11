package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(weights);

        // 측정할 수 없는 가장 작은 무게 초기화
        int smallweight = 1;

        // 정렬된 추를 순차적으로 확인
        for (int weight : weights) {
            if (weight > smallweight) {
                break;
            }
            smallweight += weight;
        }

        System.out.println(smallweight);
    }
}
