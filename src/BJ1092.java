import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BJ1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int crane = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        int craneCount = st1.countTokens();
        int[] craneW = new int[craneCount]; // 각 크레인 무게 제한

        for (int i = 0; i < craneCount; i++) {
            craneW[i] = Integer.parseInt(st1.nextToken());
        }

        int box = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int boxCount = st.countTokens();
        int[] boxW = new int[boxCount]; // 각 박스 무게

        for (int i = 0; i < boxCount; i++) {
            boxW[i] = Integer.parseInt(st.nextToken());
        }

        // 내림차순으로 정렬
        Arrays.sort(craneW);
        Arrays.sort(boxW);
        if(boxW[box - 1] > craneW[crane - 1]){
            // 상자가 가장 무거운 크레인보다 무거우면 이동할 수 없음
            System.out.println(-1);
            return;
        }
        int time = 0;
        int boxx = box;
        for (int i = 0, j = 0; i < box; i++) {
            while(boxW[i] > craneW[j]){
                j++;
            }
            // 상자를 이동
            j++;
            boxx--;
            if (j >= crane || boxx <= 0) {
                j = 0;  // 모든 크레인이 이동했을 경우 첫 번째 크레인으로 재설정
                time++;
            }
        }


        System.out.println(time);
    }
}
