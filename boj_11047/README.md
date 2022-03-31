# BOJ_11047 : 동전 0

### https://www.acmicpc.net/problem/11047
# ![image](https://user-images.githubusercontent.com/96826443/160874636-0403142c-014a-44e6-aacb-ab568b6d241c.png)


## 코드설명
* 준규는 총 N종류의 동전을 가지고 있는데, N종류의 동전으로 K원을 만드는 최소한의 동전 개수를 구해야 한다.
  * 동전의 종류 N, 보유한 동전으로 만들어야 하는 값 K원을 입력
  * ArrayList에 보유한 동전의 가치를 오름차순으로 저장
  * 보유한 동전 중 가장 가치 X원이 K원보다 작으면 K-X, cnt++
  * 작지 않으면 X원 다음으로 큰 동전으로 바꾸고 1. 반복
  * K원이 0원이 되면 반복문 종료 후 사용한 동전의 개수 출력

## 소스코드
* 메모리 : 17804 KB
* 시간 : 340 ms
* 
```java
import java.util.*;

public class code {
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
          K -= list.get(index); // 만들어야 할 K값에서 동전의 값만큼 빼준다.
          cnt++; // 동전 하나 사용했으므로 cnt++
        }
      }
    }
    System.out.println(cnt);
    sc.close(); 
  }
}
```

