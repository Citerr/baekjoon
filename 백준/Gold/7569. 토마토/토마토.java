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
    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int field = H * N * M;
    Queue<Integer> srchQ = new LinkedList<>();
    int[][][] boxes = new int[H][N][M]; 
    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
          boxes[h][n][m] = Integer.parseInt(st.nextToken());
          if (boxes[h][n][m] == 1) {
            srchQ.offer( ( h * N * M ) + (n * M) + m );
          }
          else if (boxes[h][n][m] == -1) field--;
        }
      }
    }

    //BFS
    int round = 0;
    if ( field != srchQ.size() ) {
      round = -1;
      while ( !srchQ.isEmpty() ) {
        round++;
        int sz = srchQ.size();
        field -= sz;
        for (int s = 0; s < sz; s++) {
          int idx = srchQ.poll();
          int h = idx / (N * M);
          int n = idx % (N *M) / M;
          int m = idx % (N *M) % M;
          
          if (h != H - 1) {
            if ( boxes[h + 1][n][m] == 0 ) {
              srchQ.offer( ( (h + 1) * N * M ) + (n * M) + m );
              boxes[h + 1][n][m] = 1;
            }
          }
          if (h != 0) {
            if ( boxes[h - 1][n][m] == 0 ) {
              srchQ.offer( ( (h - 1) * N * M ) + (n * M) + m );
              boxes[h - 1][n][m] = 1;
            }
          }
          if (n != N - 1) {
            if ( boxes[h][n + 1][m] == 0 ) {
              srchQ.offer( ( h * N * M ) + ((n + 1) * M) + m );
              boxes[h][n + 1][m] = 1;
            }
          }
          if (n != 0) {
            if ( boxes[h][n - 1][m] == 0 ) {
              srchQ.offer( ( h * N * M ) + ((n - 1) * M) + m );
              boxes[h][n - 1][m] = 1;
            }
          }
          if (m != M - 1) {
            if ( boxes[h][n][m + 1] == 0 ) {
              srchQ.offer( ( h * N * M ) + ( n * M) + (m + 1) );
              boxes[h][n][m + 1] = 1;
            }
          }
          if (m != 0) {
            if ( boxes[h][n][m - 1] == 0 ) {
              srchQ.offer( ( h * N * M ) + (n * M) + (m - 1) );
              boxes[h][n][m - 1] = 1;
            }
          }

        }
      }
      if (field != 0) round = -1;
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( round + " ");
    bw.flush();
    bw.close();
  }
}