# 백준 2477 :참외밭


## 코드설명
> for-loop 을 통해 입력받은 변들을 리스트에 저장한다.  
> "1", "2" 이면 가로 길이, "3", "4" 이면 세로 길이이므로 이에 따라 최대 가로, 세로 길이를 구한다.  
> 빈 참외밭의 가로, 세로 길이는 각각 가장 긴 변과 겹쳐 있는 두 변을 뺀 값과 같다.  
> 빈 공간을 무시하고 구한 최대 농장 넓이에 빈 농장 넓이를 뺀 후에 K(1제곱미터 당 참외의 개수)를 곱해준다.

## 소스코드

```java
package BOJ_prac;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2477 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		ArrayList<Integer> areaList = new ArrayList<Integer>();
		
		int K = Integer.parseInt(br.readLine()); // 1 제곱미터 넓이에 자라는 참외의 개수
		int maxWidth = Integer.MIN_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		int maxWidthIndex = 0;
		int maxHeightIndex = 0;
		int length = 0;
		
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String direction = st.nextToken();

			if (direction.equals("1") || direction.equals("2")) {
				length = Integer.parseInt(st.nextToken());
				if (length > maxWidth) {
					maxWidth = length;
					maxWidthIndex = i;
				}
			}
			
			else if (direction.equals("3") || direction.equals("4")) {
				length = Integer.parseInt(st.nextToken());
				if (length > maxHeight) {
					maxHeight = length;
					maxHeightIndex = i;
				}
			}
			areaList.add(length);
		}
		
		int emptyWidth = 0;
		int emptyHeight = 0;
		
		// 빈 참외밭 가로 길이
		if (maxHeightIndex == 0) {
			emptyWidth = Math.abs(areaList.get(maxHeightIndex + 1) - areaList.get(areaList.size() - 1));
		} else if (maxHeightIndex == areaList.size()-1) {
			emptyWidth = Math.abs(areaList.get(0) - areaList.get(maxHeightIndex-1));
		} else {
			emptyWidth = Math.abs(areaList.get(maxHeightIndex - 1) - areaList.get(maxHeightIndex + 1));
		}
		
		if (maxWidthIndex == 0) {
			emptyHeight = Math.abs(areaList.get(maxWidthIndex + 1) - areaList.get(areaList.size() - 1));
		} else if (maxWidthIndex == areaList.size()-1) {
			emptyHeight = Math.abs(areaList.get(0) - areaList.get(maxWidthIndex-1));
		} else {
			emptyHeight = Math.abs(areaList.get(maxWidthIndex - 1) - areaList.get(maxWidthIndex + 1));
		}
		
		int maxArea = maxWidth * maxHeight;
		int minArea = emptyWidth * emptyHeight;
		
		System.out.println("참외밭에서 자라는 참외의 총 개수는 {%d}개 입니다.".formatted((maxArea - minArea) * K));
		
	}
}

```

## 핵심코드
