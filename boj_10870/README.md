# 10870번 : 피보나치 수 5

### https://www.acmicpc.net/problem/10870
!![image](https://user-images.githubusercontent.com/96826443/176916007-68806f64-1026-4a07-8c52-e0503ce92bfb.png)


## 코드설명
* n번째 피보나치 수를 재귀적으로 구하여 값을 도출하는 문제이다.
* 피보나치 수는 F(n) = F(n-2) + F(n-1)의 패턴을 가지고 있기 때문에 간단한 함수를 만들어 풀이하였다.

## 소스코드
* 메모리 : 17716 KB
* 시간 : 216 ms

```java
package BOJ_prac;
import java.util.*;

public class BOJ_10870 {
	private static int fibonacci(int n) {
		
		if (n <= 1)
			return n;
		return fibonacci(n-2) + fibonacci(n-1);
	}
	public static void main(String[] args) {
		// 피보나치 수 5
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibonacci(n));
		
		
	}
}

```
