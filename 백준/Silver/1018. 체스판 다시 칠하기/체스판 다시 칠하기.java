import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken());
      int col = Integer.parseInt(st.nextToken());
      char[][] board = new char[row][col];
      for (int i = 0; row > i; i++) {
          String str = br.readLine();
          for (int j = 0; col > j; j++) {
                board[i][j] = str.charAt(j);
          }
      }
      
      int rPnt = 9999;
      for (int begX = 0; begX < row - 8 + 1; begX++) {
          for (int begY = 0; begY < col -8 + 1; begY++) {
              int case1 = 0, case2 = 0;
              for (int i = begX; i < begX + 8; i++) {
                  for (int j = begY; j < begY + 8; j++) {
                      if ( ((i+j)%2 == 0) && board[i][j] == 'B') case1++;
                      if ( ((i+j)%2 != 0) && board[i][j] == 'W') case1++;
                      
                      if ( ((i+j)%2 == 0) && board[i][j] == 'W') case2++;
                      if ( ((i+j)%2 != 0) && board[i][j] == 'B') case2++;
                  }
              }
              case1 = (case1 > case2) ? case2 : case1;
              rPnt = (rPnt > case1) ? case1 : rPnt;
          }
      }
      bw.write(rPnt + "\n");
      bw.flush();
      br.close();
      bw.close();
   }
}