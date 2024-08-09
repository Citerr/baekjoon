import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
  static int[][] table;
  static int[] dx = {-1, 0, 0, 1};
  static int[] dy = {0, -1, 1, 0};
  static HashSet<Integer> visited;
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    table = new int[N][M];

    for (int n = 0; n < N; n++) {
      st = new StringTokenizer(br.readLine());
      for (int m = 0; m < M; m++) table[n][m] = Integer.parseInt(st.nextToken());
    }

    int res = 0;
    for (int n = 0; n < N; n++) {
      for (int m = 0; m < M; m++) {
        visited = new HashSet<>();
        int case1 = DFS(n * 1000 + m, 1);
        int case2 = Tblock(n, m);
        case1 = case1 > case2 ? case1 : case2;
        res = res > case1 ? res : case1;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(res + "");
    bw.flush();
    bw.close();
  }

  static int DFS(int idx, int round) {
    int x = idx / 1000;
    int y = idx % 1000;

    if (round == 4) return table[x][y];
    visited.add( idx );

    int res = 0;
    for (int i = 0; i < 4; i++) {
      if (x + dx[i] < 0 || x + dx[i] > N - 1 || y + dy[i] < 0 || y + dy[i] > M - 1) continue;
      if ( visited.contains(idx + dx[i] * 1000 + dy[i]) ) continue;

      int temp = table[x][y] + DFS(idx + dx[i] * 1000 + dy[i], round + 1);
      res = temp > res ? temp : res;
    }

    return res;
  }

  static int Tblock(int x, int y) {
    int res = 0;
    for (int i = 0; i < 4; i++) {
      int xp = x + dx[i];
      int yp = y + dy[i];
      
      if (xp < 0 || xp > N - 1 || yp < 0 || yp > M - 1) continue;

      int least = 99999;
      int cs = table[xp][yp];
      for (int j = 0; j < 4; j++) {
        int xpp = xp + dx[j];
        int ypp = yp + dy[j];

        if (xpp < 0 || xpp > N - 1 || ypp < 0 || ypp > M - 1) {
          least = 0;
          continue;
        }
        if (xpp == x && ypp == y) continue;

        if (table[xpp][ypp] < least) least = table[xpp][ypp];
        cs += table[xpp][ypp];
      }
      cs -= least;
      res = cs > res ? cs : res;
    }
    return res + table[x][y];
  }
}