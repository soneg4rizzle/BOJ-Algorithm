# 백준 1620 : 나는야 포켓몬 마스터 이다솜

![image](https://user-images.githubusercontent.com/96826443/177008944-4ef6cbb0-bc3d-4602-9093-291fd3c880c1.png)

## 코드설명
> 먼저 N개의 포켓몬 이름을 해쉬맵에 등록하고 스트링 배열에 저장한다.  
> 그리고 M개의 문자열이 들어올 때, 이것을 숫자로 변환 가능하면 바로 저장된 배열에 값을 대입해서 포켓몬 이름을 구하고,  
>  변환 불가능하면 문자열(포켓몬 이름)이므로, 해쉬맵의 get 함수를 이용하여 해당 포켓몬의 인덱스(위치)를 찾는다.  

## 소스코드
* 메모리 : 97916 KB
* 시간 : 792 ms

```java
package BOJ_prac;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1620 {
	static boolean isString(String s) {
		try {
		       Integer.parseInt(s);
		       return true;
		   }
		   catch (NumberFormatException e) {
		       return false;
		   }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 첫째 줄에는 도감에 수록되어 있는 포켓몬의 개수 N이랑 내가 맞춰야 하는 문제의 개수 M이 주어진다.
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String pokemon[] = new String[N+1];
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			hm.put(s, i);
			pokemon[i] = s;
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if (isString(s))
				bw.write(pokemon[Integer.parseInt(s)] + "\n");
			else
				bw.write(hm.get(s) + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}

```
