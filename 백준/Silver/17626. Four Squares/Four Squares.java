import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] cases = new int[50001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int N = Integer.parseInt(br.readLine());
    // 1 <= N <= 50000

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(fSquare(N) + "");
    bw.flush();
    bw.close();
  }

  static int fSquare(int N) {
    
    if (cases[N] == 0) {
      cases[N] = 4;
      double rt = Math.sqrt(N);
      if (rt - (int)rt == 0.0) cases[N] = 1;
      else {
        for (int i = (int)rt; i > 0; i--) {
          int case1 = 1 + fSquare(N - (int)Math.pow(i, 2));
          cases[N] = case1 < cases[N] ? case1 : cases[N];
        }
      }
    }
    
    return cases[N];
  }
}