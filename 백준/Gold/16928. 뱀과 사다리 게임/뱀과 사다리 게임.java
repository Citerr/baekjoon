import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] board = new int[101]; // 0 ~ 100

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      board[ Integer.parseInt(st.nextToken()) ] = Integer.parseInt(st.nextToken());
    }
    for (int m = 0; m < M; m++) {
      st = new StringTokenizer(br.readLine());
      board[ Integer.parseInt(st.nextToken()) ] = Integer.parseInt(st.nextToken());
    }
    br.close();

    //BFS
    Queue<Integer> srchQ = new LinkedList<>();
    HashSet<Integer> visited = new HashSet<>();
    srchQ.offer(1);
    int round = 0;
    label: while ( !srchQ.isEmpty() ) {
      round++;
      int sz = srchQ.size();
      for (int s = 0; s < sz; s++) {
        int pnt = srchQ.poll();
        for (int i = 1; i <= 6; i++) {
          int newPnt = pnt + i;
          if ( visited.contains(newPnt) ) continue;
          else visited.add(newPnt); 

          if (newPnt < 100) {
            if ( board[newPnt] == 0) srchQ.offer(newPnt);
            else srchQ.offer( board[newPnt] );
          }
          else if (newPnt == 100) break label;
        }

      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(round + "");
    bw.flush();
    bw.close();
  }
}