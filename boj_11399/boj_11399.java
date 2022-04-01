import java.util.*;
import java.util.Arrays;

public class boj_11399 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int arr[] = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();
    Arrays.sort(arr);

    int time = 0;
    int sum = 0;
    for (int n : arr) {
      time = time + n; // 1 2 3 3 4-> 1 3 6 9 13
      sum += time;
    }
    System.out.print(sum);
  }
}

// 3 4 8 11 13