# 백준 7568번 : 덩치

![image](https://user-images.githubusercontent.com/96826443/176999114-9e198f4f-7ad0-4edb-b4b2-a7801c18f030.png)


## 코드설명
> 기본조건 : 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다.  
> 조건 1 : 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다.  
> 조건 1을 만족하지 않으면 누구도 상대방보다 덩치가 크다고 말할 수 없다.  
> 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.  

* 따라서, Human 클래스에 몸무게(weight), 키(height), rank(덩치 등수)를 배열로 만들어 main 문에서 사용한다.  
* for-loop을 순회하며 자신보다 덩치가 큰 사람이 존재하면 rank++ 를 진행한다.

## 소스코드
* 메모리 : 18480 KB
* 시간 : 240 ms

```java
package BOJ_prac;

import java.util.*;

class Human {
	int weight;
	int height;
	int rank = 1;
}

public class boj_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Human[] human = new Human[N];
		
		for (int i = 0; i < N; i++) {
			human[i] = new Human();
			human[i].weight = sc.nextInt();
			human[i].height = sc.nextInt();
		}
		// x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (human[i].weight < human[j].weight && human[i].height < human[j].height)
					human[i].rank++;
			}
		}
		
		for (int i = 0; i < N; i++)
			System.out.print(human[i].rank + " ");
	}
}

```

## 코드리뷰
> 단순하게 루프를 순회하며 덩치가 더 큰 사람이 있으면 해당 조건에 알맞은 처리를 진행해주면 되었다. 기초를 튼튼히 하자!
