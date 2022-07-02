# 백준 1436번 : 영화감독 숌

![image](https://user-images.githubusercontent.com/96826443/177003930-26d7a555-5f13-4f06-886c-63ceef257b06.png)


## 코드설명
> 영화감독 숌은 자신의 작품 제목에 666을 사용한다.  
> 숌의 영화 제목은 제작 순서대로 666, 1666, 2666, 3666, 4666, 5666, 6660, ... 과 같이 진행된다.  
> 이 때 숌의 N번째 영화 제목에 붙는 순서를 구하는 것이 문제의 목표이다.  
> 간단하게 while-loop 을 통하여 666부터 숫자를 1씩 증가시키며 만약 해당 문자에 666이란 값이 들어있으면 cnt를 하나씩 증가시켜주며,  
> 찾고자 하는 N번째 cnt에 해당하는 숫자를 출력해주면 된다.

## 소스코드
* 메모리 : 84796 KB
* 시간 : 280 ms

```java
package BOJ_prac;

import java.io.*;

public class boj_1436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int start = 666;
		int cnt = 0;
		
		while (true) {
			String s = Integer.toString(start);
			if (s.contains("666")) {
				cnt++;
				if (cnt == N) {
					System.out.println(start);
					break;
				}
			}
			start++;
		}
		
	}
}

```
