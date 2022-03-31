import java.util.*;

public class boj_11047 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>(); // 동전의 종류를 저장할 리스트
    int cnt = 0; // 사용한 동전의 개수
    int kind = sc.nextInt(); // N 종류의 동전
    int K = sc.nextInt(); // N 종류의 동전으로 만들어야하는 값
    for (int i = 0; i < kind; i++)
      list.add(sc.nextInt()); // 동전의 종류를 모두 list에 저장.

    int index = list.size() - 1; // 가장 큰 값의 동전부터 시작
    while (K != 0) { // 가치의 합이 0이 될때까지 가치의합-동전의종류 실행
      if (list.get(index) > K) {
        index--;
      } else {
        while (list.get(index) <= K) {
          K -= list.get(index);
          cnt++;
        }
      }
    }
    System.out.println(cnt);
    sc.close();
  }
}