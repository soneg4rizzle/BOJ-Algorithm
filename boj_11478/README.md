# 백준 11478 : 서로 다른 부분 문자열의 개수

![image](https://user-images.githubusercontent.com/96826443/177038259-6f148fe1-06c9-450c-8226-9359ff4502ff.png)


## 코드설명
> 첫 단어부터 1, 2, 3, .. 글자씩 끊어서 문자열을 저장하고 count를 1씩 올려준다. 만약 저장되어 있다면 그냥 다음 반복문으로 넘어 간다.

## 소스코드
![image](https://user-images.githubusercontent.com/96826443/177038254-c5951846-3564-4c16-ac67-0c72eb2282ac.png)

```java
package BOJ_prac;

import java.io.*;
import java.util.*;

public class boj_11478 {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		HashMap<String, Boolean> hashMap = new HashMap<String, Boolean>();
		int count = 0;
		
		String str = br.readLine();
		
		for (int i = 1; i < str.length()+1; i++) { // 1개, 2개, 3개, 4개, 5개, ... 단위로 묶어서 비교
			for (int j = 0; j < str.length(); j++) { 
				if (hashMap.get(str.substring(j, j+i)) == null) {
					hashMap.put(str.substring(j, j+i), true); 
					count++;
				}
				
				if (j+i == str.length())
					break;
			}
		}
		
		bw.write(Integer.toString(count));
		br.close();
		bw.flush();
		bw.close();
	}

}

```
