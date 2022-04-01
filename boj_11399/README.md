# BOJ_11399 ATM

![image](https://user-images.githubusercontent.com/96826443/161110760-5451d674-d11a-48fb-bf61-f18634e0e1f9.png)

## 코드설명
* 은행의 ATM기를 이용하여 N명의 사람들이 현금을 인출하려고합니다.
* 사람들은 1번부터 N번까지 번호가 메겨져있고, 돈을 인출하는데 걸리는 시간은 **P** = [P1, ... , Pn] 입니다.
* 이 때, 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 구해야합니다.
  * 1. ATM 1개로 N명의 인원이 인출을 하는 것이기 때문에 인출 시간이 짧을수록 대기인원이 기다리는 시간은 감소합니다.
  * 2. 따라서 각 사람이 돈을 인출하는데 걸리는 시간을 오름차순으로(시간이 적게 걸리는 순서대로) 정렬합니다.
  * 3. for loop을 이용하여 각 인원이 인출을 마칠때까지 기다린 시간을 sum 값에 더해줍니다.

## 소스코드
* 메모리 : 20364 KB
* 시간 : 268 ms
```java
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
```

## 리뷰
* 이 문제는 현금인출을 마칠때까지 N명의 인원들이 기다린 시간의 최솟값을 구하는 문제였습니다.
* 만약 오랜시간동안 인출을 해야하는 인원이 먼저 ATM기를 사용한다면 불필요하게 기다리는 시간이 늘어나기 때문에
* 인출시간이 짧은 사람의 순서대로 계산해주면 쉽게 인출완료까지의 최을 구할 수 있습니다.
