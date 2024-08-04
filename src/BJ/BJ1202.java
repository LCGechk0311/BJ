package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1202 {
    static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(jewel -> jewel.weight));

        Arrays.sort(bags);

        // 우선순위 큐(최대 힙)를 보석의 가격 기준으로 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long totalValue = 0; // 보석의 최대 가격 합을 저장할 변수
        int jewelIndex = 0; // 보석의 인덱스를 추적할 변수

        for (int i = 0; i < K; i++) {
            int currentBagCapacity = bags[i];

            // 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 추가
            while (jewelIndex < N && jewels[jewelIndex].weight <= currentBagCapacity) {
                maxHeap.add(jewels[jewelIndex].value);
                jewelIndex++;
            }

            // 현재 가방에 담을 수 있는 가장 값비싼 보석을 선택
            if (!maxHeap.isEmpty()) {
                totalValue += maxHeap.poll(); // 가장 값비싼 보석을 totalValue에 추가
            }
        }

        System.out.println(totalValue);
    }
}
