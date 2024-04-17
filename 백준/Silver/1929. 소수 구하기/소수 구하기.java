import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    br.close();

    int prime[] = new int[M + 1];
    boolean notPrime[] = new boolean[M + 1];
    notPrime[1] = true;

    for (int i = 2; i <= M; i++) prime[i] = i;

    int sq = (int)Math.floor( Math.sqrt((double)M) );
    for (int i = 2; prime[i] <= sq; i++) {
      if (notPrime[i]) continue;
      for (int j = prime[i] * 2; j <= M; j += prime[i]) {
        notPrime[j] = true;
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for(int i = N; i <= M; i++) { 
      if ( !notPrime[i] ) bw.write(prime[i] + "\n");
    }
    bw.flush();
    bw.close();
  }
}