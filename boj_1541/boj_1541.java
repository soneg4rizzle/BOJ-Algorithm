import java.util.*;

public class boj_1541 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    Integer result = null; // 식의 최소값을 저장할 변수

    StringTokenizer minus = new StringTokenizer(str, "-");

    while (minus.hasMoreTokens()) {
      StringTokenizer plus = new StringTokenizer(minus.nextToken(), "+");

      int sum = 0;
      while (plus.hasMoreTokens())
        sum += Integer.parseInt(plus.nextToken());

      if (result == null)
        result = sum;
      else
        result -= sum;
    }
    System.out.println(result);
  }
}