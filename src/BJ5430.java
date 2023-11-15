import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 T를 입력 받음
        int T = Integer.parseInt(br.readLine());

        // 각 테스트 케이스의 결과를 저장하기 위한 StringBuilder
        StringBuilder resultBuilder = new StringBuilder();

        // 테스트 케이스 수행
        for (int t = 0; t < T; t++) {
            // 수행할 함수 p를 입력 받음
            String p = br.readLine();

            // 배열의 크기 n을 입력 받음
            int n = Integer.parseInt(br.readLine());

            // 배열을 문자열 형태로 입력 받아 토큰으로 분리
            String input = br.readLine();
            StringTokenizer tokenizer = new StringTokenizer(input.substring(1, input.length() - 1), ",");

            // 정수 배열 초기화
            Deque<Integer> array = new ArrayDeque<>();
            while (tokenizer.hasMoreTokens()) {
                array.add(Integer.parseInt(tokenizer.nextToken()));
            }

            try {
                // 뒤집기 여부를 나타내는 변수
                boolean reverse = false;

                // 함수 수행
                for (char command : p.toCharArray()) {
                    if (command == 'R') {
                        // R일 경우 뒤집기 여부를 반전
                        reverse = !reverse;
                    } else if (command == 'D') {
                        // D일 경우 배열의 맨 앞 또는 맨 뒤에서 원소 제거
                        if (array.isEmpty()) {
                            // 배열이 비어있는데 제거 연산을 수행하면 에러
                            throw new RuntimeException("error");
                        }
                        if (reverse) {
                            // 뒤집혀진 상태에서는 배열의 맨 뒤에서 원소 제거
                            array.pollLast();
                        } else {
                            // 그렇지 않으면 배열의 맨 앞에서 원소 제거
                            array.pollFirst();
                        }
                    }
                }

                // 결과 누적
                resultBuilder.append(arrayToString(array, reverse)).append("\n");
            } catch (RuntimeException e) {
                // 에러가 발생한 경우 에러 결과 누적
                resultBuilder.append("error").append("\n");
            }
        }

        // 모든 테스트 케이스의 결과 출력
        System.out.println(resultBuilder.toString());
    }

    // 배열을 문자열로 변환하는 메소드
    private static String arrayToString(Deque<Integer> array, boolean reverse) {
        StringBuilder result = new StringBuilder("[");
        if (reverse) {
            // 뒤집혀진 상태에서는 배열을 뒤에서부터 읽어 문자열에 추가
            while (!array.isEmpty()) {
                result.append(array.pollLast());
                if (!array.isEmpty()) {
                    result.append(",");
                }
            }
        } else {
            // 그렇지 않으면 배열을 앞에서부터 읽어 문자열에 추가
            while (!array.isEmpty()) {
                result.append(array.pollFirst());
                if (!array.isEmpty()) {
                    result.append(",");
                }
            }
        }
        result.append("]");
        return result.toString();
    }
}
