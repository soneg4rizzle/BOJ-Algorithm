import java.io.*;
import java.util.StringTokenizer;

public class boj_25304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int price = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            X -= (price * num);
        }

        if (X == 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
