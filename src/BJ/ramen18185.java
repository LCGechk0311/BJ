import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class ramen18185 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); // 라면 공장 개수
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int count = st.countTokens();
        int[] A = new int[count+2]; // 각 공장에서 구매해야 하는 라면 개수
        A[A.length -2] = 0;
        A[A.length -1] = 0;

        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cost = 0; // 총 비용 초기화

        for (int i = 0; i < a; i++) {
            if (A[i] == 0) {
                continue;
            }
            int next = (i < a - 1) ? A[i + 1] : 0;
            int nextNext = (i < a - 2) ? A[i + 2] : 0;
            if (A[i] >= 1) {
                if (next > nextNext) {
                    cost += 5;
                    A[i] -= 1;
                    A[i + 1] -= 1;
                } else if ((nextNext >= next) && nextNext > 0 && next > 0) {
                    cost += 7;
                    A[i] -= 1;
                    A[i + 1] -= 1;
                    A[i + 2] -= 1;
                } else {
                    cost += 3;
                    A[i] -= 1;
                }
            }
            if (!(A[i] == 0)) {
                i -= 1;
            }
        }

        System.out.println(cost);
    }
}