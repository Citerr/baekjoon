import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  static char[][] campus;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int x = 0; int y = 0;

    campus = new char[N + 2][M + 2];
    for (int n = 1; n <= N; n++) {
      String line = br.readLine();
      for (int m = 1; m <= M; m++) {
        campus[n][m] = line.charAt(m - 1);
        if (line.charAt(m - 1) == 'I') {
          x = n;
          y = m;
        }
      }
    }

    int res = DFS(x, y);
    if (res == 0) sb.append("TT");
    else sb.append(res);
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }

  static int DFS(int x, int y) {
    if (campus[x][y] == '\u0000' || campus[x][y] == 'X') return 0;

    if (campus[x][y] == 'P') {
      campus[x][y] = 'X';
      return DFS(x + 1, y) + DFS(x - 1, y) + DFS(x, y + 1) + DFS(x, y - 1) + 1;
    }
    else  {
      campus[x][y] = 'X';
      return DFS(x + 1, y) + DFS(x - 1, y) + DFS(x, y + 1) + DFS(x, y - 1);
    }
  }
}