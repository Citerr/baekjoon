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

    char[][] maze = new char[N + 2][M + 2];
    for (int i = 1; i < N + 1; i++) {
      String str = br.readLine();
      for (int j = 1; j < M + 1; j++) {
        maze[i][j] = str.charAt(j - 1);
      }
      //maze[i] = ("0" + br.readLine() + "0").toCharArray();
    }

    //BFS
    Queue<Integer> srchQueue = new LinkedList<>(); //Index
    srchQueue.offer(M); // (1, 0) ~ N, M
    maze[1][1] = '0';
    int RES = 0;

    Label: while (true) {
      RES++;

      int sz = srchQueue.size();
      for (int i = 0; i < sz; i++) {
        int index = srchQueue.poll();
        int x = index / M;
        int y = index % M + 1; //(1, 1)
        if (x == N && y == M) break Label;

        if (maze[x][y + 1] == '1') {
          srchQueue.offer(index + 1);
          maze[x][y + 1] = '0';
        }

        if (maze[x][y - 1] == '1') {
          srchQueue.offer(index - 1);
          maze[x][y - 1] = '0';
        }

        if (maze[x + 1][y] == '1') {
          srchQueue.offer(index + M);
          maze[x + 1][y] = '0';
        }

        if (maze[x - 1][y] == '1') {
          srchQueue.offer(index - M);
          maze[x - 1][y] = '0';
        }
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(RES + "");
    bw.flush();
    bw.close();
  }
}