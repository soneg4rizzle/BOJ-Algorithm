# 백준 2447번 : 별 찍기 - 10

![image](https://user-images.githubusercontent.com/96826443/176990886-966a7a74-291b-4f2a-8986-69f763332b1a.png)



## 코드설명
* 이 문제는 3의 거듭제곱 크기(3, 9, 27, ...)를 가진 N 값이 주어지면 이에 따라 가운데가 빈 NxN 형태의 정사각형을 출력해야 했다.
* 만약 N 값으로 3을 입력 받았다면 출력해야 하는 값은 아래와 같다.

||||
|:---:|:---:|:---:|
| * | * | * |
| * | | * |
| * | * | * |

* 만약 N 값으로 9를 입력 받았다면 출력해야 하는 값은 아래와 같다.

||||||||||
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| * | * | * | * | * | * | * | * | * |
| * | | * | * | | * | * |  | * |
| * | * | * | * | * | * | * | * | * |
| * | * | * |  |  |  | * | * | * |
| * | | * |  |  |  | * |  | * |
| * | * | * |  |  |  | * | * | * |
| * | * | * | * | * | * | * | * | * |
| * | | * | * |  | * | * |  | * |
| * | * | * | * | * | * | * | * | * |

* 나는 이중배열을 이용하는 방식으로 문제를 접근 해 보았다. 
* 먼저 이중배열의 모든 값을 공백으로 만들어주고, 알고리즘을 이용하여 특정 경우에 해당할 때만 * 을 넣어주었다. 
* 알고리즘은 다음과 같다.
> 먼저 N의 크기가 커질수록 출력의 모양이 변하기 때문에 패턴이 달라질 것 같지만 자세히 들여다보면 동일한 패턴인 것을 알 수 있었다.  
> 크기가 9X9로 이루어진 정사각형의 경우에도 9 부분으로 쪼개보면 3x3 정사각형 9개로 구성된 정사각형이다.  
> 따라서 3x3 정사각형에서 공백의 위치인 (1, 1) 위치일 때를 제외하고는 모든 위치에 *을 저장하게 해주었다.  

## 소스코드
* 메모리 : 17716 KB
* 시간 : 216 ms

```java
package BOJ_prac;
import java.io.*;
import java.util.Arrays;

public class boj_2447 {
	static String arr[][]; // 별을 저장할 배열
	static void makeStar(int row, int col, int N) {
		
		if (N == 1) {
			arr[row][col] = "*";
			return;
		}
		
		int m = N / 3;
	
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) {
					continue;
				}
				makeStar(m * i + row, m * j + col, m); 
				// (0,0) ~ (0,2)
				// (1,0) ~ (1,2)
				// (2,0) ~ (2,2) => N이 3인 경우
			}
		}

	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N]; // 별을 저장할 배열
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], " ");
		}
		
		makeStar(0, 0, N);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(arr[i][j]);
			}
			bw.write('\n');
		}
		bw.flush();
		bw.close();
	}
}

}

```

## 코드리뷰
> 항상 느끼지만 공부하면서 내가 약한 부분을 마주하게 되면 겁부터 먹게 되는 것 같다. 아마도 익숙치 않은 문제라 그렇겠지만 이러한 습관은 고쳐나가야 할 것 같다.   
> 재귀 부분은 항상 알고리즘을 생각할 때는 머리가 아프다가도, 완성된 코드를 보면 오히려 허무할 때도 많은 것 같다. 어떻게 보면 이게 재귀의 장점이기도 한걸까..싶다.   
> 이번 별 찍기 문제는 나에게는 상당히 어렵게 다가왔던 것 같다.(다른 분들은 어떨지 모르겠다..) 더 열심히 공부 하자~~~

