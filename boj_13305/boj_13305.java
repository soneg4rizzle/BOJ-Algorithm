import java.util.*;

public class boj_13305 {
  public static void main(String[] args) {
    // 표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(); // 도시의 개수 N
    long sum = 0; // 마지막 도시까지 가는데 사용한 비용
    List<Long> distance = new ArrayList<>();
    List<Long> gasPrice = new ArrayList<>();

    for (int i = 1; i < N; i++) // 도시를 연결하는 도로의 거리 입력
      distance.add(sc.nextLong());
    for (int i = 1; i < N; i++) // 도시의 리터당 가스값 입력
      gasPrice.add(sc.nextLong());

    Long priceOfgas = Long.MAX_VALUE;

    for (int i = 0; i < distance.size(); i++) {
      if (gasPrice.get(i) < priceOfgas)
        priceOfgas = gasPrice.get(i);
      sum += priceOfgas * distance.get(i);
    }
    System.out.println(sum);
    sc.close();
  }
}
