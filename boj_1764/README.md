# 백준 boj_1764 : 듣보잡

![image](https://user-images.githubusercontent.com/96826443/177034040-1d04bb37-f0ff-4108-99f3-6837dc14a7a0.png)


## 코드설명
> 해쉬맵을 사용(1. 듣도 못한 사람, 2. 보도 못한 사람, 3. 입력 받은 사람)하여 이를 구분하고 듣도 보도 못한 사람이면 count++ 후 어레이리스트에 추가한다.  
> Collections.sort 메소드를 이용하여 리스트를 오름차순 정렬 후 값을 출력한다.  

## 소스코드
![image](https://user-images.githubusercontent.com/96826443/177034135-cfab7bc8-f6cd-44ed-9825-9e4cb0214726.png)

```java
package BOJ_prac;

import java.io.*;
import java.util.*;

public class boj_1764 {
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Boolean> seeMap = new HashMap<String, Boolean>();
		HashMap<String, Boolean> listenMap = new HashMap<String, Boolean>();
		HashMap<String, Boolean> nameMap = new HashMap<String, Boolean>();
		// 첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M
		// 이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과, N+2째 줄부터 보도 못한 사람의 이름
		// 듣보잡의 수와 그 명단을 사전순으로 출력한다.
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str," ");
		
		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String name = br.readLine();
			if (nameMap.get(name) == null)
				nameMap.put(name, true);
			
			if (seeMap.get(name) == null)
				seeMap.put(name, true);
		}
		
		int M = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			String name = br.readLine();
			if (nameMap.get(name) == null)
				nameMap.put(name, true);
			
			if (listenMap.get(name) == null)
				listenMap.put(name, true);
		}
		
		ArrayList<String> list = new ArrayList<String>();
		nameMap.forEach((key, value) -> {
			if (seeMap.get(key) != null && listenMap.get(key) != null) {
				list.add(key);
				count++;
			}
		});
		
		Collections.sort(list);
		bw.write(Integer.toString(count) + "\n");
		for (int i = 0; i < list.size(); i++)
			bw.write(list.get(i) + "\n");
		
		br.close();
		bw.flush();
		bw.close();
		
	}

}

```

## 핵심코드
![image](https://user-images.githubusercontent.com/96826443/177036611-59f7eb63-8d27-4329-8c1f-5e2355484a24.png)

