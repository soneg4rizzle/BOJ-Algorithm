import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class boj_1931 {
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
