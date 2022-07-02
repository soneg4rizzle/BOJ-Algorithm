# 백준 2798 : 블랙잭

![image](https://user-images.githubusercontent.com/96826443/176995936-d5c17896-a8e2-41ea-84c6-8bf209b22532.png)


## 코드설명
* N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하는 문제이다.  
* N장의 카드 중 3장의 합이 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.  

* 먼저 보유한 카드로 만들 수 있는 3장의 합에 대한 모든 경우의 수를 sumArr 배열에 넣고, 이를 M과 비교하여 가장 근접한 수를 출력한다.

## 소스코드
* 메모리 : 23280 KB
* 시간 : 252 ms

```java
ppackage BOJ_prac;
import java.util.*;

public class boj_2798 {
	static int findMaxSum(int N, int M, int[] card) {
		int answer = Integer.MAX_VALUE, index = 0;
		ArrayList<Integer> sumArr = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					sumArr.add(card[i] + card[j] + card[k]);
				}	
			}
		}
		
		for (int i = 0; i < sumArr.size(); i++) {
			if (M - sumArr.get(i) > -1) {
				if (M - sumArr.get(i) < answer)
					answer = M - sumArr.get(i);
			}
		}
		return M-answer;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int card[] = new int[N];
		for (int i = 0; i < N; i++)
			card[i] = sc.nextInt();
		
		sc.close();
		System.out.println(findMaxSum(N, M, card));
	}
}

```
