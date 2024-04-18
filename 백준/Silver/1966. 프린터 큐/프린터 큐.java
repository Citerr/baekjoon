import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int sz = Integer.parseInt(st.nextToken());
      int idx = Integer.parseInt(st.nextToken()) + 1;
      
      st = new StringTokenizer(br.readLine());
      Queue<Integer> q = new LinkedList<>();
      //내림차순
      Integer[] priority = new Integer[sz];

      for (int j = 0; j < sz; j++) {
        priority[j] = Integer.parseInt(st.nextToken());
        q.offer(Integer.valueOf(priority[j]));
      }
      Arrays.sort(priority, Collections.reverseOrder());

      for (int j = 0; j < sz; ) {
        if (priority[j] == q.peek()) {
          q.poll();
          j++;
          if (--idx == 0) {
            idx = sz - q.size();
            break;
          }
        }
        else {
          q.offer(q.poll());
          if (--idx == 0) idx = q.size();
        }
      }
      bw.write(idx + "\n");
    }
    br.close();
    bw.flush();
    bw.close();
  }
}