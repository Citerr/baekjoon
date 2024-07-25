import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int N;
  static char[][] table;
  static boolean[][] visited;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    table = new char[N + 2][N + 2];
    visited = new boolean[N + 2][N + 2];

    for (int x = 1; x < N + 1; x++) {
      String str = br.readLine();
      for (int y = 1; y < N + 1; y++) {
        table[x][y] = str.charAt(y - 1);
      }
    }

    int nm = 0;
    for (int x = 1; x < N + 1; x++) {
      for (int y = 1; y < N + 1; y++) {
        if ( !visited[x][y] ) {
          nm += DFS(x, y);
        }
        if ( table[x][y] == 'G' ) table[x][y] = 'R';
      }
    }

    visited = new boolean[N + 2][N + 2];

    int cw = 0;
    for (int x = 1; x < N + 1;  x++) {
      for (int y = 1; y < N + 1; y++) {
        if ( !visited[x][y] ) cw += DFS(x, y);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(nm + " " + cw);
    bw.flush();
    bw.close();
  }

  static int DFS(int x, int y) {
    visited[x][y] = true;
    char nowColor = table[x][y];
    for (int i = 0; i < 4; i++) {
      int X = x + dx[i];
      int Y = y + dy[i];

      if ( X < 0 || Y < 0 || X > N || Y > N ) continue;

      if (nowColor == table[X][Y] && !visited[X][Y]) DFS(X, Y);
    }
    return 1;
  }
}