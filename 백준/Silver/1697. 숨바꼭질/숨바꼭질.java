import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    ArrayList<Integer> roop = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    roop.add(N);

    int time = 0;
    if (N != K) {
      label: while ( true ) {
        ArrayList<Integer> nextRoop = new ArrayList<>();
        time++;
        for (int i : roop) {
          if (i < 0 || i > 100000) continue;
          if ( visited.contains(i) ) continue;
          visited.add(i);
          nextRoop.add(i + 1);
          nextRoop.add(i - 1);
          nextRoop.add(i * 2);
          if (nextRoop.contains(K)) break label;
        }
        roop.clear();
        roop.addAll(nextRoop);
      } 
    }

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    bw.write(time + "");
    bw.flush();
    bw.close();
  }
}