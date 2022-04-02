# BOJ_13305 : 주유소

![image](https://user-images.githubusercontent.com/96826443/161367207-3be69ad2-cc66-4cb7-9b47-eba78b659ffb.png)

## 코드설명
* 어떤 나라에 N개의 도시가 있다. 이 도시들은 일직선 도로 위에 존재할 때, 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다.
  * ```priceOfgas``` : 해당 위치로 오면서 가장 싼 가스의 가격
  * 1. 가스의 가격이 이전 도시보다 싸면 priceOfgas의 값을 현재 도시의 가스 가격으로 교체하고 다음 도시로 이동
  * 2. 가스의 가격이 이전 도시보다 비싸면 priceOfgas값을 유지한채 다음 도시로 이동

## 소스코드
* 메모리 : 20364 KB
* 시간 : 268 ms
```java
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

```

## 오답노트
![image](https://user-images.githubusercontent.com/96826443/161367406-f0ab4b6a-8845-4f5f-9723-42450a9c7e14.png)
> 서브태스크 3번을 생각하지 않고, distance, gasPrice, sum, .. 을 int 형으로 선언했다.
> int type은 –2,147,483,648 ~ 2,147,483,647 이므로, 만약 sum, priceOfgas*distance.get(i)와 같이 정수형 타입의 범위를 벗어나는 수가 나온다면 task3을 제대로 수행하지 못하기 때문에 오류가 난 것이었다.
> 따라서, 이런 오류를 방지하기 위해 해당 변수들을 long type으로 선언해주었다.

## 리뷰
> 서브태스크가 있는 문제는 익숙치 않아 헷갈렸던 것 같다. 정수형 타입의 범위를 벗어난 것을 빠르게 인지하지 못해 시간을 잡아먹은 것 같다.
> 데이터타입에 대한 기초지식을 다시 한번 탄탄하게 쌓아야겠다.
