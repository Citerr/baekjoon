import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int value = Integer.parseInt(st.nextToken());
    TreeSet<Integer> ts = new TreeSet<>();
    int ctr = 0;

    for (int i = 0; i < N; i++) 
      ts.add(Integer.parseInt(br.readLine()));
    br.close();

    while (value > 0) {
      if (ts.contains(value)) {
        value %= value;
        ctr++;
      }
      else {
        ctr += value / ts.lower(value);
        value %= ts.lower(value);
      }
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write( ctr + "\n");
    bw.flush();
    bw.close(); 
  }
}