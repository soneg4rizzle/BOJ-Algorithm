# 백준 2981 : 검문
![image](https://user-images.githubusercontent.com/96826443/193405853-18cde484-7b54-40be-88ec-212cf36bf65d.png)


# 접근방법
> 처음에는 입력받은 N개의 수의 공약수를 모두 구해서 겹치는 값을 출력되게 했다.  
> 정답 출력에는 성공했지만, 시간초과로 인해 오답이 나와 접근방식을 조금 바꿔봤다.  
> 어떤 수 X의 모듈러연산 값이 같게 하는 가능한 모든 M의 값을 구해야했다. 따라서, 수식을 적용해보았다. 

* X<sub>1</sub> = A<sub>1</sub> * M + R<sub>나머지</sub>
* X<sub>2</sub> = A<sub>2</sub> * M + R<sub>나머지</sub>
>  X<sub>1</sub> - X<sub>2</sub> = M * (A<sub>1</sub> - A<sub>2</sub>) + (R<sub>나머지</sub> - R<sub>나머지</sub>)  
>  이 때, 모듈러 연산 후 나머지 값은 동일한 값을 가지므로, X<sub>1</sub> - X<sub>2</sub> = M * (A<sub>1</sub> - A<sub>2</sub>)의 식만 남게된다.  
>  위 식에서 볼 수 있듯이, M은 A<sub>1</sub>-A<sub>2</sub>의 약수이기 때문에,
>  A<sub>1</sub>A<sub>2</sub>, A<sub>2</sub>-A<sub>3</sub>, A<sub>n-1</sub>-A<sub>n</sub>의 최대공약수를 구하고, 최대공약수의 약수를 출력하면 정답을 구할 수 있다.

# 메모리/시간
![image](https://user-images.githubusercontent.com/96826443/193406398-441fd30c-df52-459d-b1a5-9acaf321c532.png)


# 코드
```java
import java.io.*;
import java.util.Arrays;

public class boj_2981 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int gcdValue = arr[1] - arr[0];

        for (int i = 2; i < N; i++) {
            gcdValue = gcd(gcdValue, arr[i] - arr[i - 1]);
        }

        for (int i = 2; i <= gcdValue; i++) {
            if (gcdValue % i == 0)
                bw.write(i + " ");
        }
        br.close();
        bw.flush();
        bw.close();
    }


    public static int gcd(int a, int b) { // 최대공약수 구하는 함수
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
```
