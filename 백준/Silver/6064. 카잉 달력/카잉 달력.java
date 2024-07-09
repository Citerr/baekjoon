import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    
    int T = Integer.parseInt(br.readLine());
    Label: for (int i = 0; i < T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken());
      int N = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      int lcm = N * M / ( M > N ? euclidean(M, N) : euclidean(N, M) );

      int cand1 = x;
      int cand2 = y;
      int chk = cand1 < cand2 ? cand1 : cand2;

      if (x == M) x = 0;
      if (y == N) y = 0;
      while (chk <= lcm) {
        if (chk%M == x && chk%N == y) {
          sb.append(chk + "\n");
          continue Label;
        }

        if ( cand1 + M < cand2 + N ) {
          cand1 += M;
          chk = cand1;
        }
        else {
          cand2 += N;
          chk = cand2;
        }
      }
      sb.append("-1\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( sb + "" );
    bw.flush();
    bw.close();
  }

  static int euclidean(int x, int y) {
    int r = x % y;
    if (r == 0) return y;
    else return euclidean(y, r);
  }
}