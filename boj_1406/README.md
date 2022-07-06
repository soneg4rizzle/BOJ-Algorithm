# 백준 1406 : 에디터

![image](https://user-images.githubusercontent.com/96826443/177567901-637d26ec-c5ca-4856-a399-38af8e460803.png)


## 코드설명
> 편집기가 지원하는 명령어의 기능에 알맞게 결과값을 도출하는 문제였다.  
> 주어진 명령어 L, D, B, P에 대해서 스택을 이용하여 커서(cursor)의 위치를 표현 해 주었다.  
1. 일단 시작하면 입력받은 문자열을 왼쪽스택에 모두 문자로 쪼개어 넣어 준다. 
* L : 왼쪽 스택이 비어 있지 않으면 왼쪽 스택에서 pop()한 원소를 오른쪽 스택으로 이동시킨다. (커서 왼쪽으로 한 칸 이동의 효과)
* D : 오른쪽 스택이 비어 있지 않으면 오른쪽 스택에서 pop()한 원소를 왼쪽 스택으로 이동시킨다. (커서 오른쪽으로 한 칸 이동의 효과)
* B : 커서의 왼쪽에 위치한 원소를 제거 해 주어야 하기 때문에, 만약 왼쪽 스택이 비어 있지 않으면 그냥 pop()으로 왼쪽 스택 원소를 제거(빼준다)한다.  
* P $: 커서의 왼쪽에 문자를 넣어주면 되기 때문에, 왼쪽 스택에 $에 해당하는 문자를 push 한다.  
2. 모든 과정이 끝났기 때문에 왼쪽에 있던 스택을 오른쪽 스택으로 몰아 넣어주고, while-loop을 이용하여 스택에서 값을 뽑아 낸다.  

## 소스코드
![image](https://user-images.githubusercontent.com/96826443/177569823-6072052c-838d-478f-ae73-7903550bdf93.png)

```java
package baekjoon;
import java.io.*;
import java.util.*;

public class boj_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> ls = new Stack<>();
        Stack<Character> rs = new Stack<>();

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++)
            ls.push(str.charAt(i));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            switch(s.charAt(0)) {
                case 'L':
                    if (!ls.isEmpty())
                        rs.push(ls.pop());
                    break;
                case 'D':
                    if (!rs.isEmpty())
                        ls.push(rs.pop());
                    break;
                case 'B':
                    if (!ls.isEmpty())
                        ls.pop();
                    break;
                case 'P':
                    ls.push(s.charAt(2));
                    break;
            }
        }

        br.close();
        while (!ls.isEmpty())
            rs.push(ls.pop());
        while (!rs.isEmpty())
            bw.write(rs.pop());
        bw.flush();
        bw.close();
    }
}

```

## 핵심코드
![image](https://user-images.githubusercontent.com/96826443/177570002-63b394eb-3a2b-4614-83df-01c07a5beac5.png)

## 코드리뷰
> 처음에는 ArrayList<character> 형태로 리스트를 만들어 각 명령어(L, D, B, P)에 해당하는 계산을 구현하여 똑같은 값을 구했지만 시간초과로 오답이 나왔다.  
  생각해보니 해당 명령어의 구현 과정에서 커서의 위치까지 순차적으로 이동하고 만약 사이에 값이 추가되는 경우 모든 원소들을 한 칸씩 뒤로 밀어서 저장해야 하는 과정이 진행되기 때문에 O(n)의 시간복잡도가 계산되어 통과하지 못한 것 같다.
  때문에 스택을 이용하여 즉각적으로 커서의 위치에 따라서 문자를 추가해주는 방식으로 풀이했더니 문제를 통과할 수 있었다. 이런 문제는 정말 발상의 전환인 것 같다. 더 유연한 사고를 가져야 겠다.
