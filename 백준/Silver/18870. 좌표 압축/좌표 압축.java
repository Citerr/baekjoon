import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    int[] coordinate = new int[N];
    int[] ordered = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int n = 0; n < N; n++) {
      coordinate[n] = Integer.parseInt(st.nextToken());
      ordered[n] = coordinate[n];
    }
    Arrays.sort( ordered );

    int ctr = 0;
    HashMap<Integer, Integer> hm = new HashMap<>();
    for ( int i = 0; i < N; i++ ) {
      if (i > 0 && ordered[i] == ordered[i - 1]) continue;
      hm.put(ordered[i], ctr++);
    }

    for (int i : coordinate) sb.append( hm.get(i)  + " " );

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(sb + "");
    bw.flush();
    bw.close();
  }
}