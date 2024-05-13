import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static long[] P = new long[101];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    String RES = new String();
    int N = Integer.parseInt(br.readLine());
    P[1] = 1;
    P[2] = 1;
    P[3] = 1;
    P[4] = 2;
    P[5] = 2;

    for (int i = 0; i < N; i++) {
      int pn = Integer.parseInt(br.readLine());
      RES += wave(pn) + "\n";
    }
    
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(RES);
    bw.flush();
    bw.close();
  }

  static long wave(int N) {
    if (P[N] != 0) return P[N];
    else P[N] = wave(N - 1) + wave(N - 5);
    return P[N];
  }
}