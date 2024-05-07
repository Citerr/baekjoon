import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] board = new int[1000001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int N = Integer.parseInt(br.readLine());
    board[2] = 1;
    board[3] = 1;
    to1(N);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(board[N] + "");
    bw.flush();
    bw.close(); 
  }

  static int to1(int N) {
    if (N <= 3) return board[N];

    if (board[N] == 0) {
      int case1 = to1(N/3) + N%3 + 1;
      int case2 = to1(N/2) + N%2 + 1;
      board[N] = Math.min(case1, case2);
    }
    return board[N];
  }
}