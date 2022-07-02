# 백준 2231번 : 분해합

![image](https://user-images.githubusercontent.com/96826443/176997595-c163f16f-d1ed-4960-b353-ec92b17b8cbe.png)


## 코드설명
* 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.  
* 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.  
* 나는 각 자리수에서 올 수 있는 값은 9이기 때문에 (N - (자리수의 개수 * 9))부터 시작해서 생성자를 구하는 방법을 선택했다.  
* start 부터 시작해서 생성자가 존재하면  해당 생성자를 버퍼에 넣고 flag를 바꾸고 break한다. 생성자가 존재하지 않으면 버퍼에 0을 써준다.

## 소스코드
* 메모리 : 14236 KB
* 시간 : 124 ms

```java
package BOJ_prac;
import java.io.*;

public class boj_2231 {
	public static void main(String[] args) throws Exception {
		// 브루트포스 문제
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		int digits = str.length();
		int N = Integer.parseInt(str); // 분해합
		int start = N - 9 * digits;
		boolean flag = false;
		
		for (int i = start; i < N; i++) {
			int temp = i;
			int comp = i;
			while (temp != 0) {
				comp += temp % 10;
				temp /= 10;
			}
			
			if (comp == N) {
				bw.write(String.valueOf(i));
				flag = true;
				break;
			}
		}
		
		if (!flag)
			bw.write("0");
		br.close();
		bw.flush();
		bw.close();
	}
}

```

## 코드리뷰
> 문제를 풀 때 bw.write()를 이용하여 버퍼에 정수형 값을 그대로 넣어버려 값이 제대로 나오지 않았었다. BufferedWriter에 정수형을 넣기 위해서는  
> String 형으로의 변환이 필요하기 때문에 String.valueOf(정수) 함수를 이용하여 문자열 형태로 변환 하여 넣어주니 내가 원하는 값을 출력할 수 있었다.
