# BOJ_11047 : 잃어버린 괄호

### https://www.acmicpc.net/problem/11047
# ![image](https://user-images.githubusercontent.com/96826443/161310739-7a86b6bc-07c5-476e-9470-1ced92f51646.png)


## 코드설명
* 세준이는 양수, +, -, 괄호를 가지고 식을 만들었다. 주어진 식으로 만들 수 있는 최소값을 구해야 합니다.
  * StringTokenizer를 이용하여 빼기(-) 기호가 생략된 식을 생성
  * 새롭게 생성된 식을 더하기(+) 기호를 기준으로 토큰화 진행
  * 남은 토큰이 없을 때까지 토큰들을 더해줍니다.  
   ① result 에 아직 값이 들어오지 않은 경우 : result = sum  
   ② result 에 이미 값이 들어있는 경우 : result -= sum

## 소스코드
* 메모리 : 17592 KB
* 시간 : 200 ms

```java
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
```

## 리뷰
> StringTokenizer || str.split 을 이용하여 주어진 식으로부터 더하기(+) 기호와 뺄셈(-)기호를 분리한 후에 계산하면 간단히 풀 수 있는 문제였다.
