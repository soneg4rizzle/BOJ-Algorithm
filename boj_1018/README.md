# 백준 7568번 : 덩치

![image](https://user-images.githubusercontent.com/96826443/177002198-3f1c5b62-481b-4a68-9c1c-c646aff6efe3.png)


## 코드설명
> 문제 : 지민이는 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.  
> 이 때 각 칸은 BLACK/WHITE로 색칠되어 있다. 변을 공유하는 두 개의 사각형은 다른 색으로 칠해야 하는 규칙이 존재할 때 다시 칠해야 하는 최소 정사각형의 개수는??  

* 먼저, 지민이가 찾은 MxN 크기의 보드를 입력 받을 때, WHITE는 true, BLACK은 false 값을 가지는 배열을 만들었다.  
* MxN 크기의 보드는 8x8 형태의 보드로 다시 만들어 줘야 하기 때문에 입력받은 MxN 크기의 보드를 8x8 크기의 보드로 임의로 자른 후에 몇 개의 칸을 다시 칠해야 하는지 계산한다.  
* 함수 find는 색칠 해야하는 최소 정사각형(칸)의 수를 구하는 함수이다. for-loop에서는 다음 칸(행or열)로 갈 때마다 색깔이 바뀌어야 하기 때문에  
* 맨 처음 색깔을 의미하는 fir을 계속해서 반대 값으로 바꿔주며(TRUE/FALSE) 최소 색칠 수를 구할 수 있도록 한다.

## 소스코드
* 메모리 : 14216 KB
* 시간 : 140 ms

```java
package BOJ_prac;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1018 {
	static boolean board[][];
	static int min_coloring = 64;
	
	static void find(int x, int y) {
		int row_end = x + 8;
		int col_end = y + 8;
		int cnt = 0;
		
		
		// 8X8 보드의 첫 번째(맨 왼쪽 위) 색깔이 WHITE입니까 BLACK입니까?
		
		// 1. WHITE인 경우 : TRUE
		// 2. BLACK인 경우 : FALSE
		boolean fir = board[x][y];
		
		for (int i = x; i < row_end; i++) {
			for (int j = y; j < col_end; j++) {
				if (board[i][j] != fir)
					cnt++;
				
				fir = (!fir); // (행)다음 칸으로 갈 때 마다 색깔이 변해야 하므로, 비교를 위해 TRUE(WHITE)->FALSE(BLACK)으로 변경해준다.
			} fir = (!fir); // (열)다음 칸으로 갈 때 마다 색깔이 변해야 하므로, 비교를 위해 TRUE(WHITE)->FALSE(BLACK)으로 변경해준다.
		}
		
		cnt = (cnt < 64-cnt) ? cnt : 64-cnt;
		min_coloring = (cnt < min_coloring) ? cnt : min_coloring;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		// MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		board = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) { 
				if (s.charAt(j) == 'W')
					board[i][j] = true;
				else
					board[i][j] = false;
			}
		}
		
		int row_iter = N - 7;
		int col_iter = M - 7;
		for (int i = 0; i < row_iter; i++) {
			for (int j = 0; j < col_iter; j++) {
				find(i, j);
			}
		}
		
		br.close();
		System.out.println(min_coloring);
	}
}
```

## 핵심코드
![image](https://user-images.githubusercontent.com/96826443/177002405-1c8dc0cd-97a9-4a52-9aaf-a58263ec608c.png)

> 함수 내에서 칠해야 하는 칸의 최소 개수를 구할 때, 맨 처음 시작점이 BLACK 혹은 WHITE일 때로 계산 되어진다.  
> 따라서 만약 맨 처음 칸의 색이 BLACK이었다면 cnt-64는 맨 처음 칸의 색이 WHITE였을 때의 최소 색칠 개수가 된다.  
> 1. 맨 처음 색이 검은색인 경우 / 2. 맨 처음 색이 하얀색인 경우를 염두하고 계산해야 한다. 그렇지 않으면 처음 색이 BLACK/WHITE 둘 중에 하나인 경우로만 계산 되어지기 때문에 오류가 발생할 수 있다.

## 코드리뷰
> 단순하게 루프를 순회하며 덩치가 더 큰 사람이 있으면 해당 조건에 알맞은 처리를 진행해주면 되었다. 기초를 튼튼히 하자!
