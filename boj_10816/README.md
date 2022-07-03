# 백준 10816 : 숫자 카드 2

![image](https://user-images.githubusercontent.com/96826443/177034040-1d04bb37-f0ff-4108-99f3-6837dc14a7a0.png)


## 코드설명
> 백준 10815번 숫자 카드 문제와 동일하지만 상근이가 가지는 카드의 숫자가 중복 될 수 있다는 차이점이 존재했다.  
> 이번에는 숫자 카드 문제에서 BINARY SEARCHING 기법을 사용한 것과는 다르게 해쉬맵만을 사용하여 문제를 풀어 보았다.  
> 맨 처음 상근이가 가지고 있는 카드를 입력 받을 때, 해쉬맵을 이용하여 [카드 숫자, 가지고 있는 개수]의 형태로 값을 저장 해 주었다.  
> 3번째 줄에서 M개의 카드를 입력 받을 때는 앞서 저장한 해쉬맵에서 카드가 몇 개 존재하는지 비교하여 쉽게 답을 도출 해 내었다.

## 소스코드
![image](https://user-images.githubusercontent.com/96826443/177034135-cfab7bc8-f6cd-44ed-9825-9e4cb0214726.png)

```java
package BOJ_prac;
import java.io.*;
import java.util.*;

public class boj_10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			int token = Integer.parseInt(st.nextToken());
			if (hashMap.get(token) == null)
				hashMap.put(token, 1);
			else
				hashMap.put(token, hashMap.get(token)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int check[] = new int[M];
		
		for (int i = 0; i < M; i++) {
			int comp = Integer.parseInt(st.nextToken());
			if (hashMap.get(comp) == null) {
				hashMap.put(comp, 0);
				check[i] = 0;
			}
			else {
				check[i] = hashMap.get(comp);
			}
		}
		
		for (int i = 0; i < M; i++)
			bw.write(check[i] + " ");
		
//		hashMap.forEach((key, value) -> {
//			System.out.println(key + " : " + value);	
//		});	
		
		br.close();
		bw.flush();
		bw.close();
		
	}
}

```

## 핵심코드
![image](https://user-images.githubusercontent.com/96826443/177034158-ff20c300-afe7-40fa-aa9c-ab274d0f3bcc.png)

> 해쉬맵을 이용하여 입력 받은 숫자 카드의 개수를 저장하는 코드 부분이 핵심 코드라고 여겨진다.

## 코드리뷰
> 처음에 이분 탐색으로 똑같이 풀어보려고 했지만 시간초과 에러도 발생하고, 무엇보다도 곰곰히 생각해보니 해쉬맵을 사용하면 충분히 쉽게 풀 수 있을 것이라는 생각이 들었다.  
> 항상 생각의 폭을 넓혀서 접근하는 연습을 해야 겠다.
