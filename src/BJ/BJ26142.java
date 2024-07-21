package BJ;

import java.io.*;
import java.util.*;

public class BJ26142 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] D = new int[N];
        long[] H = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D[i] = Integer.parseInt(st.nextToken());
            H[i] = Long.parseLong(st.nextToken());
        }

        long[] heights = new long[N];
        for (int i = 0; i < N; i++) {
            heights[i] = H[i];
        }

        long cumulativeSum = 0;

        for (int k = 1; k <= N; k++) {
            // 현재 키를 기준으로 maxHeap 초기화
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < N; i++) {
                maxHeap.add(heights[i]);
            }

            // 도둑이 최대 키의 드래곤을 쏘는 경우
            long maxCut = maxHeap.poll();
            cumulativeSum += maxCut;

            System.out.println(cumulativeSum);

            // maxCut 키를 가진 드래곤 찾기
            for (int i = 0; i < N; i++) {
                if (heights[i] == maxCut) {
                    heights[i] = 0;
                    break;
                }
            }

            // heights 배열을 내림차순으로 정렬하여 다음 날을 준비
            Long[] heightsWrapper = Arrays.stream(heights).boxed().toArray(Long[]::new);
            Arrays.sort(heightsWrapper, Collections.reverseOrder());
            heights = Arrays.stream(heightsWrapper).mapToLong(Long::longValue).toArray();

            // 모든 드래곤의 키를 D[i]만큼 증가
            for (int i = 0; i < N; i++) {
                heights[i] += D[i];
            }
        }

        br.close();
    }
}

// 실패