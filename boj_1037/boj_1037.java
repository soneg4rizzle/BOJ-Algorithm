import java.io.*;
import java.util.StringTokenizer;

public class boj_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄에 N의 진짜 약수의 개수가 주어진다.
        // 이 개수는 50보다 작거나 같은 자연수이다. 둘째 줄에는 N의 진짜 약수가 주어진다.
        // 1,000,000보다 작거나 같고, 2보다 크거나 같은 자연수이고, 중복되지 않는다.

        // 첫째 줄에 N을 출력한다. N은 항상 32비트 부호있는 정수로 표현할 수 있다.

        int N = Integer.parseInt(br.readLine()); // N의 진짜 약수의 개수(진짜 약수는 1, N을 제외한 약수를 의미)
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int number;

        if (N == 1) {
            number = Integer.parseInt(st.nextToken());
            System.out.println(number * number);
        } else {
            for (int i = 0; i < N; i++) {
                int value = Integer.parseInt(st.nextToken());
                if (value > max) max = value;
                if (value < min) min = value;
            } // 진짜 약수 중 가장 큰 값을 찾아 변수 max 에 할당시킨다.
            System.out.println(max * min);
        }
    }
}
