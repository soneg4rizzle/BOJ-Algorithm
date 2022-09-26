import java.io.*;
import java.util.StringTokenizer;

public class boj_5086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력은 여러 테스트 케이스로 이루어져 있다.
        // 각 테스트 케이스는 10,000이 넘지않는 두 자연수로 이루어져 있다.
        // 마지막 줄에는 0이 2개 주어진다. 두 수가 같은 경우는 없다.

        // 각 테스트 케이스마다
        // 첫 번째 숫자가 두 번째 숫자의 약수라면 factor를, 배수라면 multiple을, 둘 다 아니라면 neither를 출력

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 == 0 && n2 == 0) break;

            if (n2 % n1 == 0) System.out.println("factor");
            else if (n1 % n2 == 0) System.out.println("multiple");
            else System.out.println("neither");
        }
    }
}
