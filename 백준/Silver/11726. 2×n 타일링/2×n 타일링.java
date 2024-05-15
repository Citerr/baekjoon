import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] cases = new int[1001];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int N = Integer.parseInt(br.readLine());
    cases[1] = 1;
    cases[2] = 2;
    cases[3] = 3;

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(tiling(N) + "");
    bw.flush();
    bw.close();
  }

  static int tiling(int N) {
    if (cases[N] != 0) return cases[N];
    else {
      cases[N] = (tiling(N - 1) + tiling(N - 2)) % 10007;
      return cases[N];
    }
  }
}