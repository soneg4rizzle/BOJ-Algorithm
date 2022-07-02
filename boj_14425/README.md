# 백준 10815번 : 숫자카드(이분 탐색)

![image](https://user-images.githubusercontent.com/96826443/177007768-eb48f041-46ea-4db3-921d-7771ae13f0e0.png)

## 코드설명
> 입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구해야 한다.  
> HashMap 을 이용하여 N개의 key 값으로 입력 받은 문자열을, value에는 True 값을 넣어준다.
> 그 이후 입력 받는 M개의 문자열에 대하여 해쉬맵에 존재하면 카운트를 늘리는 방식으로 알고리즘을 작성하였다.

## 소스코드
* 메모리 : 31608 KB
* 시간 : 404 ms

```java
package BOJ_prac;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Boolean> hm = new HashMap<String, Boolean>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for (int i = 0; i < N; i++)
			hm.put(br.readLine(), true);
		
		for (int i = 0; i < M; i++) {
			if (hm.get(br.readLine()) != null)
				count++;
		}
		bw.write(Integer.toString(count));
		
		br.close();
		bw.flush();
		bw.close();
	}
}

```
