# BOJ_1931 : 회의실 배정

![image](https://user-images.githubusercontent.com/96826443/161053187-b441f9f2-f009-41df-bf72-d5cc62b22469.png)

## 코드설명
* 한 개의 회의실에서 열리는 N개의 회의에 대해 시간이 겹치지 않는 선에서 회의실을 사용한다고 할 때 진행할 수 있는 회의의 최대 개수를 찾는 문제입니다.
  * 회의의 개수 N개를 입력받습니다.
  * 각 회의의 시작/종료 시간을 for loop을 통해 리스트에 저장합니다.
  * 람다객체를 이용하여 Comparator.comparing(Object::Method)로 회의 시간을 정렬합니다.  
    * 종료 시간이 빠른 회의를 오름차순으로 정렬  
    * 종료 시간이 같은 회의가 있을 수 있기 때문에 1.에 대해서 시작 시간이 빠른 순서대로 재정렬
    

## 소스코드  
 *메모리 : 76516 KB  
 *시간 : 680 ms
 
```java
import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class_1931  {
  public static class Time {
    private int start; // 회의 시작시간
    private int end; // 회의 종료시간

    public Time(int start, int end) { //
      this.start = start;
      this.end = end;
    }

    public int getStartTime() { //
      return start;
    }

    public int getEndTime() {
      return end;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine()); // 회의의 수 N
    int max_cnt = 0; // 겹치지 않게 사용 가능한 최대 회의의 수 max_cnt
    List<Time> list = new ArrayList<Time>(); // 각 회의의 시작시간과 종료시간을 저장할 ArrayList

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      StringTokenizer st = new StringTokenizer(str, " ");
      list.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))); // 각 회의의 시작/종료시간을 리스트에 저장
    }
    br.close();
    list.sort(Comparator.comparing(Time::getEndTime).thenComparing(Time::getStartTime)); 
    // 
    int start = 0;
    int end = 0;
    for (int i = 0; i < list.size(); i++) {
      if (i == 0) {
        start = list.get(i).start;
        end = list.get(i).end;
        max_cnt++;
        continue;
      }
      int new_s = list.get(i).start;
      int new_e = list.get(i).end;
      if (new_s >= end) {
        max_cnt++;
        start = new_s;
        end = new_e;
      }
    }
    System.out.print(max_cnt);
  }
}
```
## 핵심코드
```java
list.sort(Comparator.comparing(Time::getEndTime).thenComparing(Time::getStartTime)); 
```
> 회의 시작/종료 시간을 각각 s, t로 놓는다면 s<=t 의 관계에 있기 때문에 가장 중요한 포인트는 각 회의가 종료되는 시간을 오름차순으로 배열하는 것이었다.
> 또한 종료시간이 같은 경우, 시작 시간이 빠른 회의가 먼저 시작되어야 하기 때문에 종료시간을 정렬 한 후에 시작 시간을 오름차순으로 정렬해주었다.

## 오답노트
> 처음 시도 할 때에는 종료 시간을 오름차순으로 배열하면 최대 회의의 수를 구할 수 있다고 생각했기 때문에 종료시간만을 정렬하였다.  
```각 회의의 종료시간을 기준으로 오름차순 정렬하는 코드```   
```java
list.sort(Comparator.comparing(Time::getEndTime));
```  
> 하지만 만약 종료시간이 같은 경우에 대해서 시작 시간이 더 빠른 회의가 있다면 해당 회의가 먼저 시작되어야 한다.
> 따라서 종료시간을 정렬한 리스트에 대해서 시작시간을 한번 더 오름차순 정렬해주었다.  
```회의의 종료시간이 같은 경우에 thenComparing 을 이용하여 시간이 더 빠른 회의가 오름차순 배열되도록 작성한 코드```  
```java
list.sort(Comparator.comparing(Time::getEndTime).thenComparing(Time::getStartTime)); 
```  
## 리뷰
> 간단해 보이는 문제였지만, 문제의 메커니즘을 정확히 이해하지 못해 생각보다 많은 시간이 소요되었다. 문제 발생 시에 무엇보다 주목해야 할 점은 해당 상황을 정확하게 인지하고 해결해야 한다는 점임을 배울 수 있었다.
