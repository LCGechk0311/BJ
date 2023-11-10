import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0; // 봉지 개수 초기화

        // 5킬로그램 봉지를 최대한 사용
        while (N > 0) {
            if(N == 1 || N == 2 || N == 4 || N == 7){ // 예외 처리
                count = -1;
                break;
            }else{
                if (N % 5 == 0) {
                    count += N / 5;
                    N = 0;
                    break;
                }
                N -= 3; // 5킬로그램 봉지를 사용할 수 없는 경우 3킬로그램 봉지 사용
                count++;
            }
        }
        System.out.println(count);
    }
}
