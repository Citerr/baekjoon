import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int[] binSch = new int[N];

    for (int i = 0; i < N; i++) {
      binSch[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(binSch);

    long start = 1;
    long end = binSch[N  - 1];
    while (start <= end) {
      int k = 0;
      long mid = (start + end)/2;
      for (int i: binSch) k += i/mid;
      if (k >= K) {
        start = ++mid;
      } else if (k < K) {
        end = --mid;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(end + "\n");
    bw.flush();
    bw.close();
  }
}