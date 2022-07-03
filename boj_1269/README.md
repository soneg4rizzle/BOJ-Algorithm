# 백준 1269번 : 대칭 차집합

![image](https://user-images.githubusercontent.com/96826443/177037009-986641b6-9355-404f-80d3-fc98b29b107d.png)


## 코드설명
> 해쉬맵을 사용하여 겹치는 원소가 있으면 교집합 원소 개수(intersec_cnt)를 하나 늘려주고,  
> 최종적으로 (A 합집합 B) - 2 * (A 교집합 B) 의 값을 도출 해 낸다.

## 소스코드
![image](https://user-images.githubusercontent.com/96826443/177037076-31bb85e0-dd5c-4d92-85ba-184d80e3fa8c.png)

```java
package BOJ_prac;

import java.util.*;

public class boj_1269 {
	static int intersec_cnt = 0;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Boolean> mapA = new HashMap<Integer, Boolean>();
		HashMap<Integer, Boolean> mapB = new HashMap<Integer, Boolean>();
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		for (int i = 0; i < N; i++)
			mapA.put(sc.nextInt(), true);
		
		for (int i = 0; i < M; i++)
			mapB.put(sc.nextInt(), true);
		
		int sum = mapA.size() + mapB.size(); // (A 합집합 B)
		mapA.forEach((key, value) -> {
			if (mapB.get(key) != null)
				intersec_cnt++;
		});
		sum -= (2 * intersec_cnt);
		System.out.println(sum);
	}

}
```
