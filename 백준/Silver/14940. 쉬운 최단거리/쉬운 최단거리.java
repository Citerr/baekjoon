import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    
    int goal = 0;
    int[][] tbl = new int[N + 2][M + 2];
    int[][] RES = new int[N + 2][M + 2];
    for (int i = 1; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j < M + 1; j++) {
        tbl[i][j] = Integer.parseInt(st.nextToken());
        if (tbl[i][j] == 2) goal = i * M + j - 1;
        else if (tbl[i][j] != 0) RES[i][j] = -1;
      }
    }
    
    Queue<Integer> srchQ = new LinkedList<>();
    srchQ.offer(goal);
    int distant = 0;
    while ( !srchQ.isEmpty() ) {
      distant++;
      int sz = srchQ.size();
      for (int i = 0; i < sz; i++) {
        int point = srchQ.poll();
        int x = point / M;
        int y = point % M + 1;

        if (tbl[x + 1][y] == 1) {
          tbl[x + 1][y] = 0;
          srchQ.offer( point + M );
          RES[x + 1][y] = distant;
        }

        if (tbl[x - 1][y] == 1) {
          tbl[x - 1][y] = 0;
          srchQ.offer( point - M );
          RES[x - 1][y] = distant;
        }

        if (tbl[x][y + 1] == 1) {
          tbl[x][y + 1] = 0;
          srchQ.offer( point + 1 );
          RES[x][y + 1] = distant;
        }

        if (tbl[x][y - 1] == 1) {
          tbl[x][y - 1] = 0;
          srchQ.offer( point - 1 );
          RES[x][y - 1] = distant;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < M + 1; j++) sb.append( RES[i][j] + " " );
      sb.append("\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( sb + "" );
    bw.flush();
    bw.close();
  }
}