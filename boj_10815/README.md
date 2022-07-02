# 백준 10815번 : 숫자카드(이분 탐색)

![image](https://user-images.githubusercontent.com/96826443/177006842-67fa60b8-9ac4-43f0-b6ac-51d782e6ad8e.png)

## 코드설명
> 숫자 카드 N개를 가지고 있을 때, 정수 M개 중 보유하고 있는 카드를 구별하는 문제이다.  
> 이 문제는 이분 탐색을 이용하여 간단히 구할 수 있는 문제였다. 이를 위해 N개의 정수를 입력 받은 후에 오름차순으로 정렬을 진행하였다.  
> 그 후에, M개의 정수에 대해서 Binary Search 를 진행하여 탐색 속도를 높여 시간 내에 정답을 구할 수 있었다.  
> 알고리즘은 간단하다. 정렬 된 배열의 중간 인덱스 값부터 비교하여 해당 값보다 작으면 왼쪽으로 절반을 나누어 다시 비교를 진행하고, 해당 값보다 크면 오른쪽으로 절반을 나누어 비교를 진행한다.  
> 탐색 범위를 절반으로 나누고 비교하기 때문에 앞에서 하나씩 모두 비교하는 것에 비해 빨리 탐색을 완료할 수 있다.

## 소스코드
* 메모리 : 124784 KB
* 시간 : 1368 ms

```java
package BOJ_prac;
import java.io.*;
import java.util.*;

public class boj_10815 {
	static String binsearch(ArrayList<Integer> list, int card, int start, int end) {
		if (start > end)
			return "0";
		
		int mid = (start + end) / 2;
		
		if (card == list.get(mid))
			return "1";
		else if (card < list.get(mid))
			return binsearch(list, card, start, mid-1);
		else
			return binsearch(list, card, mid+1, end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			bw.write(binsearch(list, key, 0, list.size()-1) + " ");
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
}
```

## 코드리뷰
> 처음에는 그냥 배열에 값을 넣어주고 단순 비교하여 정답을 구했다. 하지만 이렇게 답을 구하니 시간초과로 인해 테스트를 통과하지 못했다. 이러한 문제를 해결하기 위해서 이진탐색을 이용했다.
