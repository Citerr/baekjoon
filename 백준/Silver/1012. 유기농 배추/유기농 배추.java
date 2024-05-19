import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
  static int[][] field;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    for(int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      int Y = Integer.parseInt(st.nextToken());
      field = new int[X + 2][Y + 2];
      int K = Integer.parseInt(st.nextToken());

      
      for (int k = 0; k < K; k++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) + 1;
        int y = Integer.parseInt(st.nextToken()) + 1;
        field[x][y] = 1;
      }

      int bugs = 0;
      for (int x = 1; x <= X; x++) {
        int k = 0;
        for (int y = 1; y <= Y; y++) {
          if (field[x][y] == 0) continue;
          else {
            k += bug(x, y);
            bugs++;
          }
        }
        if (k >= K) {
          break;
        }
      }
        
      sb.append(bugs + "\n");
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }

  static int bug(int x, int y) {
    if (field[x][y] == 0) return 0;
    field[x][y] = 0; //ctr = 1
    return bug(x + 1, y) + bug(x - 1, y) + bug(x, y + 1) + bug(x, y - 1) + 1;
  }
}