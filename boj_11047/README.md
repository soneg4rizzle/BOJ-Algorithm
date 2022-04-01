# BOJ_11047 : 동전 0

### https://www.acmicpc.net/problem/11047
![image](https://user-images.githubusercontent.com/96826443/161315684-4f1ef0b9-59fa-43d7-ab98-430c5b78179c.png)


## 코드설명
* 준규는 N종류의 동전을 가지고 있다. 준규가 가진 동전을 이용하여 K원을 만드려고 할 때 필요한 동전의 최소 개수를 구하여라
 * 구해야 하는 가치의 합이 K원이라고 할 때, 준규가 가지고 있는 동전 중 가장 가치가 큰 동전을 X원이라고 하자
 * X <= K 를 만족한다면 K -= X 를 반복한다.
 * 만약 K가 0이 된다면, 가진 동전을 사용하여 K원을 완성시킨 것이므로 반복문을 멈추고 사용한 동전 개수를 출력한다.

## 소스코드
* 메모리 : 17804 KB
* 시간 : 340 ms

```java
import java.util.*;

public class boj_11047 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>(); // 동전의 종류를 저장할 리스트
    int cnt = 0; // 사용한 동전의 개수
    int kind = sc.nextInt(); // N 종류의 동전
    int K = sc.nextInt(); // N 종류의 동전으로 만들어야하는 값
    for (int i = 0; i < kind; i++)
      list.add(sc.nextInt()); // 동전의 종류를 모두 list에 저장

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
```
